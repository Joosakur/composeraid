package net.joosa.composeraid.music.scales;

import net.joosa.composeraid.music.intervals.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScaleType {

    protected List<Interval> intervals = new ArrayList<>();
    protected String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScaleType scaleType = (ScaleType) o;
        return Objects.equals(name, scaleType.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public String getName() {
        return name;
    }
}
