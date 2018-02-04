package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class MinMaj7 extends ChordQuality{

    public MinMaj7() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.major().seventh());
        this.name = "mmaj7";

        this.types.add(Type.SEVENTH);
        this.types.add(Type.MINOR);
    }
}
