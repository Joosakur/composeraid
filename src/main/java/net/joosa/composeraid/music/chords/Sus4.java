package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

public class Sus4 extends ChordQuality {

    public Sus4() {
        this.intervals.add(Interval.perfect().unison());
        this.intervals.add(Interval.perfect().fourth());
        this.intervals.add(Interval.perfect().fifth());
        this.name = "sus4";
        this.types.add(Type.TRIAD);
        this.types.add(Type.SUSTAINED);
    }

}
