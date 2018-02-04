package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.AbsoluteNote;
import net.joosa.composeraid.music.RelativeNote;

import java.util.List;

public class Chord {

    private RelativeNote root;
    private ChordQuality quality;

    private List<AbsoluteNote> notes;
    private String name;

    public Chord(RelativeNote root, ChordQuality quality) {
        this.root = root;
        this.quality = quality;
        this.name = root.getName() + quality.getName();
    }

    public RelativeNote getRoot() {
        return root;
    }

    public ChordQuality getQuality() {
        return quality;
    }

    public String getName() {
        return name;
    }

    public AbsoluteChord toAbsolute(int octave, int inversion) {
        return new AbsoluteChord(root, quality, octave, inversion);
    }
}
