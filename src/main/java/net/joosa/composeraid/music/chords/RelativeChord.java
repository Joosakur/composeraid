package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.RelativeNote;
import net.joosa.composeraid.music.intervals.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RelativeChord {

    private RelativeNote root;
    private ChordQuality quality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelativeChord that = (RelativeChord) o;
        return Objects.equals(root, that.root) &&
                Objects.equals(quality, that.quality);
    }

    @Override
    public int hashCode() {

        return Objects.hash(root, quality);
    }

    private List<RelativeNote> notes;
    private String name;

    public RelativeChord(RelativeNote root, ChordQuality quality) {
        this.root = root;
        this.quality = quality;
        this.name = root.getName() + quality.getName();
        calculateNotes();
    }

    private void calculateNotes() {
        notes = new ArrayList<>();
        for (Interval interval : quality.intervals) {
            notes.add(root.up(interval));
        }
    }

    public RelativeNote getRoot() {
        return root;
    }

    public ChordQuality getQuality() {
        return quality;
    }

    public List<RelativeNote> getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    public AbsoluteChord toAbsolute(int octave, int inversion) {
        return new AbsoluteChord(root, quality, octave, inversion);
    }
}
