package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Min7 extends ChordQuality {

    public Min7() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.minor().seventh());
        this.name = "m7";

        this.types.add(Type.SEVENTH);
        this.types.add(Type.MINOR);
    }
}
