package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Min extends ChordQuality{

    public Min() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.perfect().fifth());
        this.name = "m";
        this.types.add(Type.TRIAD);
        this.types.add(Type.MINOR);
    }
}
