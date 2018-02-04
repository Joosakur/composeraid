package net.joosa.composeraid.music.intervals;

public class Interval {
    private int semitones;
    private int baseNumber;
    private String name;
    private String shortName;


    protected Interval(int baseNumber, int semitones, String name, String shortName) {
        this.semitones = semitones;
        this.name = name;
        this.shortName = shortName;
    }

    public static Diminished diminished() {
        return new Diminished();
    }

    public static Minor minor() {
        return new Minor();
    }

    public static Perfect perfect() {
        return new Perfect();
    }

    public static Major major() {
        return new Major();
    }

    public static Augmented augmented() {
        return new Augmented();
    }

    public int getSemitones() {
        return semitones;
    }

    public String getName() {
        return name;
    }

    public int getBaseNumber() {
        return baseNumber;
    }

    public String getShortName() {
        return shortName;
    }

    public Interval clone() {
        return new Interval(baseNumber, semitones, name, shortName);
    }
}
