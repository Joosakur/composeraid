package net.joosa.composeraid.music.keys;

import net.joosa.composeraid.music.chords.*;
import net.joosa.composeraid.music.scales.MajorScale;

public class MajorKey extends AbstractKeyType {
    public MajorKey() {
        super(
                new MajorScale(),
                new ChordGroup("Triad", new Maj(), new Min(), new Min(), new Maj(), new Maj(), new Min(), new Dim()),
                new ChordGroup("7th", new Maj7(), new Min7(), new Min7(), new Maj7(), new Dominant7(), new Min7(), new HalfDim7()),
                new ChordGroup("9th", new Maj9(), new Min9(), new Min7b9(), new Maj9(), new Dominant9(), new Min9(), new HalfDim7b9()),
                new ChordGroup("sus2", new Sus2(), new Sus2(), null, new Sus2(), new Sus2(), new Sus2(), null),
                new ChordGroup("sus4", new Sus4(), new Sus4(), new Sus4(), null, new Sus4(), new Sus4(), null),
                new ChordGroup("6th", new Maj6(), new Min6(), null, new Maj6(), new Maj6(), null, null),
                new ChordGroup("V/x", new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7), new ChordQuality(new Maj(), 7), null),
                new ChordGroup("V7/x", new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7), new ChordQuality(new Dominant7(), 7), null),
                new ChordGroup("VII/x", new ChordQuality(new Dim(), -1), new ChordQuality(new Maj(), -2), new ChordQuality(new Maj(), -2), new ChordQuality(new Dim(), -1), new ChordQuality(new Dim(), -1), new ChordQuality(new Maj(), -2), null),
                new ChordGroup("VII7/x", new ChordQuality(new HalfDim7(), -1), new ChordQuality(new Dominant7(), -2), new ChordQuality(new Dominant7(), -2), new ChordQuality(new HalfDim7(), -1), new ChordQuality(new HalfDim7(), -1), new ChordQuality(new Dominant7(), -2), null)
        );
    }
}
