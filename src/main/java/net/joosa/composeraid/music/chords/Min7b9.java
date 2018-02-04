package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Min7b9 extends ChordQuality {

    public Min7b9() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.minor().seventh());
        this.intervals.add(Interval.minor().ninth());
        this.name = "m7b9";
        this.types.add(Type.EXTENDED);
        this.types.add(Type.MINOR);
    }
}
