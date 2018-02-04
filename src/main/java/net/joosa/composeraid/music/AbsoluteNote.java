package net.joosa.composeraid.music;

import net.joosa.composeraid.music.intervals.Interval;

import java.util.Objects;

public class AbsoluteNote {

    private int midiCode;
    private int octave;
    private RelativeNote relative;

    public AbsoluteNote(int midiCode) {
        this.midiCode = midiCode;
        relative = new RelativeNote(midiCode);
    }

    public AbsoluteNote(int octave, RelativeNote relative) {
        this.octave = octave;
        this.relative = relative;
        midiCode = (octave+2)*12 + relative.getNumber();
    }

    public String getName() {
        return relative.getName() + octave;
    }

    public AbsoluteNote up(int semitones) {
        return new AbsoluteNote(this.midiCode + semitones);
    }

    public AbsoluteNote up(Interval interval) {
        return up(interval.getSemitones());
    }

    public AbsoluteNote down(int semitones) {
        return new AbsoluteNote(this.midiCode - semitones);
    }

    public AbsoluteNote down(Interval interval) {
        return down(interval.getSemitones());
    }

    public int getMidiCode() {
        return midiCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsoluteNote that = (AbsoluteNote) o;
        return midiCode == that.midiCode;
    }

    @Override
    public int hashCode() {

        return Objects.hash(midiCode);
    }

    public int getOctave() {
        return octave;
    }

    public RelativeNote getRelative() {
        return relative;
    }
}
