package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Dim extends ChordQuality  {

    public Dim() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.minor().third());
        this.intervals.add(Interval.diminished().fifth());
        this.name = "dim";
        this.types.add(Type.TRIAD);
        this.types.add(Type.DIMINISHED);
    }
}
