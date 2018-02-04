package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Aug7 extends ChordQuality {

    public Aug7() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().third());
        this.intervals.add(Interval.augmented().fifth());
        this.intervals.add(Interval.major().seventh());
        this.name = "aug7";
        this.types.add(Type.SEVENTH);
        this.types.add(Type.AUGMENTED);
    }
}
