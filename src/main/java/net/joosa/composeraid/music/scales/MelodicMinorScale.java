package net.joosa.composeraid.music.scales;

import net.joosa.composeraid.music.intervals.Interval;

public class MelodicMinorScale extends ScaleType {
    public MelodicMinorScale() {
        intervals.add(Interval.perfect().unison());
        intervals.add(Interval.major().second());
        intervals.add(Interval.minor().third());
        intervals.add(Interval.perfect().fourth());
        intervals.add(Interval.perfect().fifth());
        intervals.add(Interval.major().sixth());
        intervals.add(Interval.major().seventh());
        name = "Melodic Minor";
    }
}
