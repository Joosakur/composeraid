package net.joosa.composeraid.music.chords;

import net.joosa.composeraid.music.intervals.Interval;

import java.util.*;

public class ChordQuality {

    protected List<Interval> intervals = new ArrayList<>();
    protected Set<Type> types = new HashSet<>();
    protected String name;
    protected int shift;

    public ChordQuality() {
    }

    public ChordQuality(ChordQuality base, int shift) {
        this.intervals = base.getIntervals();
        this.types = base.getTypes();
        this.name = base.getName();
        this.shift = shift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChordQuality that = (ChordQuality) o;
        return shift == that.shift &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, shift);
    }

    public int getShift() {
        return shift;
    }

    public Maj major() {
        return new Maj();
    }

    public Min minor() {
        return new Min();
    }

    public Dim diminished() {
        return new Dim();
    }

    public Aug augmented() {
        return new Aug();
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public String getName() {
        return name;
    }

    public enum Type {
        MAJOR,
        MINOR,
        DIMINISHED,
        AUGMENTED,
        TRIAD,
        SEVENTH,
        SIXTH,
        EXTENDED,
        SUSTAINED
    }

    @Override
    public ChordQuality clone() {
        ChordQuality chord = new ChordQuality();
        for (Interval interval : intervals) {
            chord.getIntervals().add(interval.clone());
        }
        for (Type type : types) {
            chord.getTypes().add(type);
        }
        chord.name = this.name+"";
        return chord;
    }

    public ChordQuality extendWith(Interval interval) {
        int base = interval.getBaseNumber();

        if(base != 9 && base != 11 && base != 13)
            throw new IllegalArgumentException("Can only extend with 9, 11 or 13");
        if(types.contains(Type.DIMINISHED))
            throw new IllegalArgumentException("Can not extend diminished chord");
        if(types.contains(Type.SUSTAINED))
            throw new IllegalArgumentException("Can not extend sustained chord");


        for (Interval existing : intervals) {
            if(base == existing.getBaseNumber())
                throw new IllegalArgumentException("Already has an interval of "+base);
            if(interval.getSemitones() == existing.getSemitones())
                throw new IllegalArgumentException("Already has enharmonically equal tone");
            if(base > existing.getBaseNumber())
                throw new IllegalArgumentException("Please extend in order");
        }

        ChordQuality chord = this.clone();

        String intSymbol;
        switch (interval.getSemitones()) {
            case 13: intSymbol = "b9";break;
            case 14: intSymbol = "9";break;
            case 15: intSymbol = "#9";break;
            case 16: intSymbol = "b11";break;
            case 17: intSymbol = "11";break;
            case 18: intSymbol = "#11";break;
            case 20: intSymbol = "b13";break;
            case 21: intSymbol = "13";break;
            case 22: intSymbol = "#13";break;
            default: throw new IllegalArgumentException("Cant extend with "+interval.getSemitones()+" semitones");
        }
        if(chord.isContinuousBefore(interval.getBaseNumber())) {
            if(chord.getName().contains("b") || chord.getName().contains("#") ||
                    intSymbol.contains("b") || intSymbol.contains("#")) {
                chord.name += intSymbol;
            }
            else {
                if(chord.getName().endsWith("7") || chord.getName().endsWith("9"))
                    chord.name = chord.name.substring(0, chord.name.length()-1) + base;
                else if(chord.getName().endsWith("11"))
                    chord.name = chord.name.substring(0, chord.name.length()-2) + base;
                else
                    chord.name += intSymbol;
            }
        } else {
            chord.name += "add" + intSymbol;
        }

        chord.getIntervals().add(interval);
        chord.getTypes().add(Type.EXTENDED);
        return chord;
    }

    private boolean isContinuousBefore(int baseInterval) {
        if(baseInterval > 7) {
            if(!intervals.contains(Interval.diminished().seventh()) &&
                    !intervals.contains(Interval.minor().seventh()) &&
                    !intervals.contains(Interval.major().seventh()))
                return false;
        }
        if(baseInterval > 9) {
            if(!intervals.contains(Interval.minor().ninth()) &&
                    !intervals.contains(Interval.major().ninth()) &&
                    !intervals.contains(Interval.augmented().ninth()))
                return false;
        }
        if(baseInterval > 11) {
            if(!intervals.contains(Interval.diminished().eleventh()) &&
                    !intervals.contains(Interval.perfect().eleventh()) &&
                    !intervals.contains(Interval.augmented().eleventh()))
                return false;
        }
        return true;
    }

}
