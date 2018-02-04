package net.joosa.composeraid.gui;

import net.joosa.composeraid.midi.DeviceManager;
import net.joosa.composeraid.music.AbsoluteNote;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Key extends JPanel{
    private Keyboard keyboard;
    private AbsoluteNote note;
    private boolean white;
    private boolean pressed;

    public Key(AbsoluteNote note, boolean visible, Keyboard keyboard) {
        this.keyboard = keyboard;
        this.note = note;
        this.white = note.getRelative().getName().length() == 1;
        if(visible)
            this.addMouseListener(mouseListener);

    }

    private MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            try {
                keyboard.playNote(note, 100);
            } catch (InvalidMidiDataException | MidiUnavailableException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            try {
                keyboard.releaseNote(note);
            } catch (InvalidMidiDataException | MidiUnavailableException e1) {
                e1.printStackTrace();
            }
        }
    };

    public AbsoluteNote getNote() {
        return note;
    }

    public void press(int velocity) throws InvalidMidiDataException, MidiUnavailableException {
        ShortMessage msg = new ShortMessage(ShortMessage.NOTE_ON, 0, note.getMidiCode(), velocity);
        DeviceManager.getReceiver().send(msg, -1);
        pressed = true;
    }

    public void release() throws InvalidMidiDataException, MidiUnavailableException {
        ShortMessage msg = new ShortMessage(ShortMessage.NOTE_OFF, 0, note.getMidiCode(), 0);
        DeviceManager.getReceiver().send(msg, -1);
        pressed = false;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(white
                ? pressed ? Color.CYAN : Color.WHITE
                : pressed ? Color.BLUE : Color.DARK_GRAY
        );
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.getWidth(), this.getHeight()-1);
        if(!white) g.setColor(Color.white);
        g.drawChars(note.getName().toCharArray(), 0, note.getName().length(), 10, white ? this.getHeight() - 20 : 20);
    }

}
