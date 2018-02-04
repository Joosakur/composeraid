package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Min6 extends ChordQuality {

    public Min6() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.major().sixth());
        this.name = "m6";
        this.types.add(Type.MINOR);
        this.types.add(Type.SIXTH);
    }
}
