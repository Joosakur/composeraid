package net.joosa.composeraid.music.intervals;

public class Prefix {

    Type type;

    public Prefix(Type type) {
        this.type = type;
    }

    public enum Type {
        DIMINISHED,
        MINOR,
        PERFECT,
        MAJOR,
        AUGMENTED
    }
}
