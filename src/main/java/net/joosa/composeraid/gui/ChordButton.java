package net.joosa.composeraid.gui;

import net.joosa.composeraid.music.AbsoluteNote;
import net.joosa.composeraid.music.RelativeNote;
import net.joosa.composeraid.music.chords.RelativeChord;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ChordButton extends JButton {

    private int inversion;
    private RelativeChord chord;
    private Keyboard keyboard;
    private List<AbsoluteNote> notesPlaying = new ArrayList<>();

    public ChordButton(RelativeChord chord, int inversion, Keyboard keyboard) {
        this.keyboard = keyboard;
        this.inversion = inversion;
        this.chord = chord;
        if(inversion==0)
            this.setText(chord.getName());
        this.setSize(100, 70);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    press(3, null);
                } catch (InvalidMidiDataException | MidiUnavailableException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                try {
                    release();
                } catch (InvalidMidiDataException | MidiUnavailableException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }


    public void press(int octave, RelativeNote bass) throws InvalidMidiDataException, MidiUnavailableException {
        release();
        if(! notesPlaying.isEmpty())
            return;

        for (AbsoluteNote note : chord.toAbsolute(octave,inversion).getNotes()) {
            keyboard.playNote(note, 70);
            notesPlaying.add(note);
        }

        if(bass==null) {
            AbsoluteNote bassNote = chord.getRoot().toAbsolute(octave).down(24);
            keyboard.playNote(bassNote, 70);
            notesPlaying.add(bassNote);
        } else {
            AbsoluteNote bassNote = bass.toAbsolute(octave - 2);
            keyboard.playNote(bassNote, 70);
            notesPlaying.add(bassNote);
        }

    }

    public void release() throws InvalidMidiDataException, MidiUnavailableException {
        ListIterator<AbsoluteNote> iterator = notesPlaying.listIterator();
        while (iterator.hasNext()) {
            AbsoluteNote note = iterator.next();
            keyboard.releaseNote(note);
            iterator.remove();
        }
    }

}
