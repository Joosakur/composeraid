package net.joosa.composeraid.music.keys;

import net.joosa.composeraid.music.scales.ScaleType;

public interface KeyType {
    ScaleType getScaleType();

    ChordGroup getTriads();

    ChordGroup getSeventh();

    ChordGroup getNinth();

    ChordGroup getSus2();

    ChordGroup getSus4();

    ChordGroup getSixth();

    ChordGroup getSecDomV();

    ChordGroup getSecDomV7();

    ChordGroup getSecDomVII();

    ChordGroup getSecDomVII7();
}
