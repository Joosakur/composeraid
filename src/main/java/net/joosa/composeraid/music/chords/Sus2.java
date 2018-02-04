package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Sus2 extends ChordQuality {

    public Sus2() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.major().second());
        this.intervals.add(Interval.perfect().fifth());
        this.name = "sus2";
        this.types.add(Type.TRIAD);
        this.types.add(Type.SUSTAINED);
    }

}
