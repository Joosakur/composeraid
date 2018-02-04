package net.joosa.composeraid.gui;

import net.joosa.composeraid.music.RelativeNote;
import net.joosa.composeraid.music.chords.ChordQuality;
import net.joosa.composeraid.music.chords.RelativeChord;
import net.joosa.composeraid.music.intervals.Interval;
import net.joosa.composeraid.music.keys.ChordGroup;
import net.joosa.composeraid.music.keys.KeyType;
import net.joosa.composeraid.music.scales.ScaleType;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ChordPanel extends JPanel {

    private Keyboard keyboard;

    private JLabel d1 = new JLabel("I");
    private JLabel d2 = new JLabel("II");
    private JLabel d3 = new JLabel("III");
    private JLabel d4 = new JLabel("IV");
    private JLabel d5 = new JLabel("V");
    private JLabel d6 = new JLabel("VI");
    private JLabel d7 = new JLabel("VII");
    private List<JLabel> degreeLabels = Arrays.asList(d1, d2, d3, d4, d5, d6, d7);


    public ChordPanel(RelativeNote root, KeyType keyType, Keyboard keyboard) {
        this.keyboard = keyboard;
        this.setLayout(new GridLayout(0,22));
        addChordGroup(root, keyType.getScaleType(), keyType.getSecDomVII7());
        addChordGroup(root, keyType.getScaleType(), keyType.getSecDomVII());
        addChordGroup(root, keyType.getScaleType(), keyType.getSecDomV7());
        addChordGroup(root, keyType.getScaleType(), keyType.getSecDomV());
        addChordGroup(root, keyType.getScaleType(), keyType.getSixth());
        addChordGroup(root, keyType.getScaleType(), keyType.getSus4());
        addChordGroup(root, keyType.getScaleType(), keyType.getSus2());
        addChordGroup(root, keyType.getScaleType(), keyType.getNinth());
        addChordGroup(root, keyType.getScaleType(), keyType.getSeventh());
        addChordGroup(root, keyType.getScaleType(), keyType.getTriads());

        this.add(new JLabel("Chord degree"));
        for (JLabel degreeLabel : degreeLabels) {
            degreeLabel.setHorizontalAlignment(JLabel.CENTER);
            this.add(new JLabel(""));
            this.add(degreeLabel);
            this.add(new JLabel(""));
        }
    }

    private void addChordGroup(RelativeNote root, ScaleType scaleType, ChordGroup chordGroup) {
        this.add(new JLabel(chordGroup.getName()));
        for(int i=0; i<7; i++) {
            ChordQuality chordQuality = chordGroup.getChordQuality(i + 1);
            if(chordQuality!=null) {
                Interval interval = scaleType.getIntervals().get(i);
                RelativeNote chordRoot = root.up(interval);
                chordRoot = chordRoot.up(chordQuality.getShift());
                RelativeChord chord = new RelativeChord(chordRoot, chordQuality);
                this.add(new ChordButton(chord, -1, keyboard ));
                this.add(new ChordButton(chord, 0, keyboard));
                this.add(new ChordButton(chord, 1, keyboard));
            } else {
                this.add(new JButton("-"));
                this.add(new JButton("-"));
                this.add(new JButton("-"));
            }
        }
    }

}
