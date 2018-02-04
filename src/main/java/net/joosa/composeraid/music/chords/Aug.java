package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Aug extends ChordQuality {

    public Aug() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().third());
        this.intervals.add(Interval.augmented().fifth());
        this.name = "aug";
        this.types.add(Type.TRIAD);
        this.types.add(Type.AUGMENTED);
    }
}
