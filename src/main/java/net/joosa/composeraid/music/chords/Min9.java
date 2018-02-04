package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Min9 extends ChordQuality {

    public Min9() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.minor().seventh());
        this.intervals.add(Interval.major().ninth());
        this.name = "m9";
        this.types.add(Type.EXTENDED);
        this.types.add(Type.MINOR);
    }
}
