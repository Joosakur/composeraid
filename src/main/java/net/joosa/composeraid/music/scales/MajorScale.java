package net.joosa.composeraid.music.scales;

import net.joosa.composeraid.music.intervals.Interval;

public class MajorScale extends ScaleType {
    public MajorScale() {
        intervals.add(Interval.perfect().unison());
        intervals.add(Interval.major().second());
        intervals.add(Interval.major().third());
        intervals.add(Interval.perfect().fourth());
        intervals.add(Interval.perfect().fifth());
        intervals.add(Interval.major().sixth());
        intervals.add(Interval.major().seventh());
        name = "Major (Ionian)";
    }
}
