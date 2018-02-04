package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Maj7 extends ChordQuality {

    public Maj7() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.major().seventh());
        this.name = "maj7";
        this.types.add(Type.SEVENTH);
        this.types.add(Type.MAJOR);
    }
}
