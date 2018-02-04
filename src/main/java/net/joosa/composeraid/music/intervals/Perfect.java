package net.joosa.composeraid.music.intervals;

public class Perfect extends Prefix{

    public Perfect() {
        super(Type.PERFECT);
    }

    public Interval unison() {
        return new Interval(1,0, "Perfect Unison", "P1");
    }

    public Interval fourth() {
        return new Interval(4,5, "Perfect 4th", "P4");
    }

    public Interval fifth() {
        return new Interval(5,7, "Perfect 5th", "P5");
    }

    public Interval octave() {
        return new Interval(8,12, "Perfect Octave", "P8");
    }

    public Interval eleventh() {
        return new Interval(11,17, "Perfect Eleventh", "P11");
    }


}
