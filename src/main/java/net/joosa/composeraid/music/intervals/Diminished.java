package net.joosa.composeraid.music.intervals;

public class Diminished extends Prefix{

    public Diminished() {
        super(Type.DIMINISHED);
    }

    public Interval second() {
        return new Interval(2,0, "Diminished 2nd", "d2");
    }
    public Interval third() {
        return new Interval(3,2, "Diminished 3rd", "d3");
    }
    public Interval fourth() {
        return new Interval(4,4, "Diminished 4th", "d4");
    }
    public Interval fifth() {
        return new Interval(5,6, "Diminished 5th", "d5");
    }
    public Interval sixth() {
        return new Interval(6,7, "Diminished 6th", "d6");
    }
    public Interval seventh() {
        return new Interval(7,9, "Diminished 7th", "d7");
    }
    public Interval octave() {
        return new Interval(8,11, "Diminished Octave", "d8");
    }
    public Interval eleventh() {
        return new Interval(11,16, "Diminished 11th", "d11");
    }

}
