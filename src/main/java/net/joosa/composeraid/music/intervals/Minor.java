package net.joosa.composeraid.music.intervals;

public class Minor extends Prefix{

    public Minor() {
        super(Type.MINOR);
    }

    public Interval second() {
        return new Interval(2,1, "Minor 2nd", "m2");
    }

    public Interval third() {
        return new Interval(3,3, "Minor 3rd", "m3");
    }

    public Interval sixth() {
        return new Interval(6,8, "Minor 6th", "m6");
    }

    public Interval seventh() {
        return new Interval(7,10, "Minor 7th", "m7");
    }

    public Interval ninth() {
        return new Interval(9,13, "Minor 9th", "m9");
    }

    public Interval thirteenth() {
        return new Interval(13,20, "Minor 13th", "m13");
    }

}
