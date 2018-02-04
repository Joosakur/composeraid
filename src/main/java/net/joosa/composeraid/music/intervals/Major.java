package net.joosa.composeraid.music.intervals;

public class Major extends Prefix{

    public Major() {
        super(Type.MAJOR);
    }

    public Interval second() {
        return new Interval(2,2, "Major 2nd", "M2");
    }

    public Interval third() {
        return new Interval(3,4, "Major 3rd", "M3");
    }

    public Interval sixth() {
        return new Interval(6,9, "Major 6th", "M6");
    }

    public Interval seventh() {
        return new Interval(7, 11, "Major 7th", "M7");
    }

    public Interval ninth() {
        return new Interval(9,14, "Major 9th", "M9");
    }

    public Interval thirteenth() {
        return new Interval(13,21, "Major 13th", "M13");
    }


}
