package net.joosa.composeraid.music;

import net.joosa.composeraid.music.intervals.Interval;

import java.util.Objects;

public class RelativeNote {
    private int number; // 0 = C
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelativeNote that = (RelativeNote) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    public RelativeNote(int number) {
        this.number = number;
        switch (number%12) {
            case 0:
                name = "C";
                break;
            case 1:
                name = "Db";
                break;
            case 2:
                name = "D";
                break;
            case 3:
                name = "Eb";
                break;
            case 4:
                name = "E";
                break;
            case 5:
                name = "F";
                break;
            case 6:
                name = "F#";
                break;
            case 7:
                name = "G";

                break;
            case 8:
                name = "Ab";
                break;
            case 9:
                name = "A";
                break;
            case 10:
                name = "Bb";
                break;
            case 11:
                name = "B";
                break;
        }
    }

    public RelativeNote up(int semitones) {
        int number = this.number + semitones;
        while (number > 11) number -= 12;
        while (number < 0) number += 12;

        return new RelativeNote(number);
    }

    public RelativeNote up(Interval interval) {
        return up(interval.getSemitones());
    }

    public RelativeNote down(int semitones) {
        return up(-semitones);
    }

    public RelativeNote down(Interval interval) {
        return down(interval.getSemitones());
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public AbsoluteNote toAbsolute(int octave) {
        return new AbsoluteNote(octave, this);
    }
}
