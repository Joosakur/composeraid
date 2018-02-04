package net.joosa.composeraid.music.scales;

import net.joosa.composeraid.music.intervals.Interval;

public class HarmonicMinorScale extends ScaleType {
    public HarmonicMinorScale() {
        intervals.add(Interval.perfect().unison());
        intervals.add(Interval.major().second());
        intervals.add(Interval.minor().third());
        intervals.add(Interval.perfect().fourth());
        intervals.add(Interval.perfect().fifth());
        intervals.add(Interval.minor().sixth());
        intervals.add(Interval.major().seventh());
        name = "Harmonic Minor";
    }
}
