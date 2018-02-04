package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Maj6 extends ChordQuality {

    public Maj6() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.major().sixth());
        this.name = "6";
        this.types.add(Type.MAJOR);
        this.types.add(Type.SIXTH);
    }
}
