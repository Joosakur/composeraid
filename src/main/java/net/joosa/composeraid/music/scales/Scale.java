package net.joosa.composeraid.music.scales;

import net.joosa.composeraid.music.RelativeNote;
import net.joosa.composeraid.music.intervals.Interval;

import java.util.HashSet;
import java.util.Set;

public class Scale {
    Set<RelativeNote> relativeNotes = new HashSet<>();

    public Scale(ScaleType type, RelativeNote root) {
        for (Interval interval : type.getIntervals()) {
            relativeNotes.add(root.up(interval));
        }
    }
}
