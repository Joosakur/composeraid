package net.joosa.composeraid.music.keys;

import net.joosa.composeraid.music.scales.ScaleType;

import java.util.Objects;

public abstract class AbstractKeyType implements KeyType {
    private ScaleType scaleType;
    private ChordGroup triads;
    private ChordGroup seventh;
    private ChordGroup ninth;
    private ChordGroup sus2;
    private ChordGroup sus4;
    private ChordGroup sixth;
    private ChordGroup secDomV;
    private ChordGroup secDomV7;
    private ChordGroup secDomVII;
    private ChordGroup secDomVII7;

    public AbstractKeyType(ScaleType scaleType, ChordGroup triads, ChordGroup seventh, ChordGroup ninth, ChordGroup sus2, ChordGroup sus4, ChordGroup sixth, ChordGroup secDomV, ChordGroup secDomV7, ChordGroup secDomVII, ChordGroup secDomVII7
    ) {
        this.scaleType = scaleType;
        this.triads = triads;
        this.seventh = seventh;
        this.ninth = ninth;
        this.sus2 = sus2;
        this.sus4 = sus4;
        this.sixth = sixth;
        this.secDomV = secDomV;
        this.secDomV7 = secDomV7;
        this.secDomVII = secDomVII;
        this.secDomVII7 = secDomVII7;
    }

    @Override
    public ScaleType getScaleType() {
        return scaleType;
    }

    public void setScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    @Override
    public ChordGroup getTriads() {
        return triads;
    }

    public void setTriads(ChordGroup triads) {
        this.triads = triads;
    }

    @Override
    public ChordGroup getSeventh() {
        return seventh;
    }

    public void setSeventh(ChordGroup seventh) {
        this.seventh = seventh;
    }

    @Override
    public ChordGroup getNinth() {
        return ninth;
    }

    public void setNinth(ChordGroup ninth) {
        this.ninth = ninth;
    }

    @Override
    public ChordGroup getSus2() {
        return sus2;
    }

    public void setSus2(ChordGroup sus2) {
        this.sus2 = sus2;
    }

    @Override
    public ChordGroup getSus4() {
        return sus4;
    }

    public void setSus4(ChordGroup sus4) {
        this.sus4 = sus4;
    }

    @Override
    public ChordGroup getSixth() {
        return sixth;
    }

    public void setSixth(ChordGroup sixth) {
        this.sixth = sixth;
    }

    @Override
    public ChordGroup getSecDomV() {
        return secDomV;
    }

    public void setSecDomV(ChordGroup secDomV) {
        this.secDomV = secDomV;
    }

    @Override
    public ChordGroup getSecDomV7() {
        return secDomV7;
    }

    public void setSecDomV7(ChordGroup secDomV7) {
        this.secDomV7 = secDomV7;
    }

    @Override
    public ChordGroup getSecDomVII() {
        return secDomVII;
    }

    public void setSecDomVII(ChordGroup secDomVII) {
        this.secDomVII = secDomVII;
    }

    @Override
    public ChordGroup getSecDomVII7() {
        return secDomVII7;
    }

    public void setSecDomVII7(ChordGroup secDomVII7) {
        this.secDomVII7 = secDomVII7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractKeyType that = (AbstractKeyType) o;
        return Objects.equals(scaleType, that.scaleType) &&
                Objects.equals(triads, that.triads) &&
                Objects.equals(seventh, that.seventh) &&
                Objects.equals(ninth, that.ninth) &&
                Objects.equals(sus2, that.sus2) &&
                Objects.equals(sus4, that.sus4) &&
                Objects.equals(sixth, that.sixth) &&
                Objects.equals(secDomV, that.secDomV) &&
                Objects.equals(secDomV7, that.secDomV7) &&
                Objects.equals(secDomVII, that.secDomVII) &&
                Objects.equals(secDomVII7, that.secDomVII7);
    }

    @Override
    public int hashCode() {

        return Objects.hash(scaleType, triads, seventh, ninth, sus2, sus4, sixth, secDomV, secDomV7, secDomVII, secDomVII7);
    }
}
