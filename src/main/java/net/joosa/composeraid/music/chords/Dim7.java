package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Dim7 extends ChordQuality  {

    public Dim7() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.diminished().fifth());
        this.intervals.add(Interval.diminished().seventh());
        this.name = "dim7";
        this.types.add(Type.SEVENTH);
        this.types.add(Type.DIMINISHED);
    }
}
