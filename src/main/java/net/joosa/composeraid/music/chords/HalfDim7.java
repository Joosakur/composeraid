package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class HalfDim7 extends ChordQuality {

    public HalfDim7() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.diminished().fifth());
        this.intervals.add(Interval.minor().seventh());
        this.name = "m7b5";

        this.types.add(Type.SEVENTH);
        this.types.add(Type.MINOR);
        this.types.add(Type.DIMINISHED);
    }
}
