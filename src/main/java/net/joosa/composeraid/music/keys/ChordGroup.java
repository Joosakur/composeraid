package net.joosa.composeraid.music.keys;

import net.joosa.composeraid.music.chords.ChordQuality;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ChordGroup {
    private String name;
    private List<ChordQuality> chordQualities;

    public ChordGroup(String name, List<ChordQuality> chordQualities) {
        this.name = name;
        this.chordQualities = chordQualities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChordGroup that = (ChordGroup) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(chordQualities, that.chordQualities);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, chordQualities);
    }

    public ChordGroup(String name, ChordQuality... chordQualities) {
        this.name = name;

        this.chordQualities = Arrays.asList(chordQualities);
    }

    public String getName() {
        return name;
    }

    public ChordQuality getChordQuality(int degree) {
        return chordQualities.get(degree-1);
    }
}
