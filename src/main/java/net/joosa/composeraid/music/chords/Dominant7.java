package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Dominant7 extends ChordQuality {

    public Dominant7() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.minor().seventh());
        this.name = "7";
        this.types.add(Type.SEVENTH);
        this.types.add(Type.MAJOR);
    }
}
