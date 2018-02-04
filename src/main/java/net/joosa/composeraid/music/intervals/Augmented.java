package net.joosa.composeraid.music.intervals;

public class Augmented extends Prefix{

    public Augmented() {
        super(Type.AUGMENTED);
    }

    public Interval unison() {
        return new Interval(1,1, "Augmented Octave", "A8");
    }
    public Interval second() {
        return new Interval(2,3, "Augmented 2nd", "A2");
    }
    public Interval third() {
        return new Interval(3,5, "Augmented 3rd", "A3");
    }
    public Interval fourth() {
        return new Interval(4,6, "Augmented 4th", "A4");
    }
    public Interval fifth() {
        return new Interval(5,8, "Augmented 5th", "A5");
    }
    public Interval sixth() {
        return new Interval(6,10, "Augmented 6th", "A6");
    }
    public Interval seventh() {
        return new Interval(7,12, "Augmented 7th", "A7");
    }
    public Interval ninth() {
        return new Interval(9,15, "Augmented 9th", "A9");
    }
    public Interval eleventh() {
        return new Interval(11,18, "Augmented 11th", "A11");
    }
    public Interval thirteenth() {
        return new Interval(13,22, "Augmented 13th", "A13");
    }

}
