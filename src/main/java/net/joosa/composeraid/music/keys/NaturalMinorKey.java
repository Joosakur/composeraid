package net.joosa.composeraid.music.keys;

import net.joosa.composeraid.music.chords.*;
import net.joosa.composeraid.music.scales.NaturalMinorScale;

public class NaturalMinorKey extends AbstractKeyType {
    public NaturalMinorKey() {
        super(
                new NaturalMinorScale(),
                new ChordGroup("Triad", new Min(), new Dim(), new Maj(), new Min(), new Min(), new Maj(), new Maj()),
                new ChordGroup("7th", new Min7(), new HalfDim7(), new Maj7(), new Min7(), new Min7(), new Maj7(), new Dominant7()),
                new ChordGroup("9th", new Min9(), new HalfDim7b9(), new Maj9(), new Min9(), new Min7b9(), new Maj9(), new Dominant9()),
                new ChordGroup("sus2", new Sus2(), null, new Sus2(), new Sus2(), null, new Sus2(), new Sus2()),
                new ChordGroup("sus4", new Sus4(), null, new Sus4(), new Sus4(), new Sus4(), null, new Sus4()),
                new ChordGroup("6th", null, null, new Maj6(), new Min6(), null, new Maj6(), new Maj6()),
                new ChordGroup("V/x", new ChordQuality(new Maj(), 7), null, new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7)),
                new ChordGroup("V7/x", new ChordQuality(new Dominant7(), 7), null, new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7)),
                new ChordGroup("VII/x", new ChordQuality(new Maj(), -2), null, new ChordQuality(new Dim(), -1), new ChordQuality(new Maj(), -2), new ChordQuality(new Maj(), -2), new ChordQuality(new Dim(), -1), new ChordQuality(new Dim(), -1)),
                new ChordGroup("VII7/x", new ChordQuality(new Dominant7(), -2), null, new ChordQuality(new HalfDim7(), -1), new ChordQuality(new Dominant7(), -2), new ChordQuality(new Dominant7(), -2), new ChordQuality(new HalfDim7(), -1), new ChordQuality(new HalfDim7(), -1))
        );
    }
}
