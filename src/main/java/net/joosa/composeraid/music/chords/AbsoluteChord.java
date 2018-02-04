package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.AbsoluteNote;
import net.joosa.composeraid.music.RelativeNote;
import net.joosa.composeraid.music.intervals.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AbsoluteChord {

    private RelativeNote root;
    private ChordQuality quality;
    private int inversion;
    private int octave;

    private List<AbsoluteNote> notes;
    private String name;

    public AbsoluteChord(RelativeNote root, ChordQuality quality, int octave, int inversion) {
        this.root = root;
        this.quality = quality;
        this.octave = octave;
        this.inversion = inversion;
        this.name = root.getName() + quality.getName();
        calculateNotes();
    }

    private void calculateNotes() {
        notes = new ArrayList<>();
        AbsoluteNote rootNote = new AbsoluteNote(octave, root);
        for (Interval interval : quality.intervals) {
            notes.add(rootNote.up(interval));
        }
        while (inversion > 0) {
            AbsoluteNote note = notes.get(0);
            notes.remove(0);
            notes.add(note.up(12));
            inversion--;
        }
        while (inversion < 0) {
            AbsoluteNote note = notes.get(notes.size()-1);
            notes.remove(notes.size()-1);
            notes.add(0, note.down(12));
            inversion++;
        }
    }

    public RelativeNote getRoot() {
        return root;
    }

    public ChordQuality getQuality() {
        return quality;
    }

    public int getInversion() {
        return inversion;
    }

    public int getOctave() {
        return octave;
    }

    public List<AbsoluteNote> getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsoluteChord that = (AbsoluteChord) o;
        return inversion == that.inversion &&
                octave == that.octave &&
                Objects.equals(root, that.root) &&
                Objects.equals(quality, that.quality);
    }

    @Override
    public int hashCode() {

        return Objects.hash(root, quality, inversion, octave);
    }
}
