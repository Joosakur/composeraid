package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Dominant9 extends ChordQuality {

    public Dominant9() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.minor().seventh());
        this.intervals.add(Interval.major().ninth());
        this.name = "9";
        this.types.add(Type.EXTENDED);
        this.types.add(Type.MAJOR);
    }
}
