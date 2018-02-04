package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Maj extends ChordQuality {

    public Maj() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().third());
        this.intervals.add(Interval.perfect().fifth());
        this.name = "";
        this.types.add(Type.TRIAD);
        this.types.add(Type.MAJOR);

    }

    public Maj7 maj7() {
        return new Maj7();
    }

    public Dominant7 d7() {
        return new Dominant7();
    }
}
