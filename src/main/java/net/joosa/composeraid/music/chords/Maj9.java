package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Maj9 extends ChordQuality {

    public Maj9() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().third());
        this.intervals.add(Interval.perfect().fifth());
        this.intervals.add(Interval.major().seventh());
        this.intervals.add(Interval.major().ninth());
        this.name = "maj9";
        this.types.add(Type.EXTENDED);
        this.types.add(Type.MAJOR);
    }
}
