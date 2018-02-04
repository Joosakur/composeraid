package net.joosa.composeraid.gui;

import net.joosa.composeraid.music.AbsoluteNote;
import net.joosa.composeraid.music.RelativeNote;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Keyboard extends JPanel {

    private AbsoluteNote root;
    private int numOfNotes;
    private int numOfVisibleWhites = 0;

    private Map<AbsoluteNote, Key> keys = new HashMap<>();
    private List<Key> visibleKeys = new ArrayList<>();

    public Keyboard(AbsoluteNote root, int numOfNotes) {
        super(null);
        this.root = root;
        this.numOfNotes = numOfNotes;
    }

    public void playNote(AbsoluteNote note, int velocity) throws InvalidMidiDataException, MidiUnavailableException {
        Key key = keys.get(note);
        key.press(velocity);

        for (Key visibleKey : visibleKeys) {
            visibleKey.repaint();
        }
        this.revalidate();
        this.repaint();
    }

    public void releaseNote(AbsoluteNote note) throws InvalidMidiDataException, MidiUnavailableException {
        keys.get(note).release();

        this.revalidate();
        this.repaint();
    }

    public void init() {
        this.setVisible(false);

        AbsoluteNote note = new AbsoluteNote(-1, new RelativeNote(9));

        int firstVisible = root.getMidiCode();
        if(root.getRelative().getName().length() > 1)
            firstVisible--;
        int lastVisible = root.getMidiCode() + numOfNotes - 1;
        if(root.getRelative().getName().length() > 1)
            lastVisible++;

        for(int i=0; i<88; i++) {
            boolean visible = note.getMidiCode() >= firstVisible && note.getMidiCode() <= lastVisible;
            Key key = new Key(note, visible, this);
            keys.put(note, key);
            if(visible) {
                visibleKeys.add(key);
                if(key.isWhite())
                    numOfVisibleWhites++;
            }

            note = note.up(1);
        }

        int width = this.getWidth();
        int height = this.getHeight();
        numOfNotes = visibleKeys.size();
        int whiteWidth = width / numOfVisibleWhites;
        int blackWidth = whiteWidth * 2 / 3;
        int blackHeight = height * 5 / 9;

        int x = 0;
        for (Key key : visibleKeys) {
            if(!key.isWhite())
                x -= blackWidth / 2;

            Dimension size = new Dimension(key.isWhite() ? whiteWidth : blackWidth, key.isWhite() ? height : blackHeight);
            this.add(key);
            key.setSize(size);
            key.setPreferredSize(size);
            key.setBounds(x, 0, size.width, size.height);
            key.setVisible(true);

            if(key.isWhite())
                x += whiteWidth;
            else
                x += blackWidth / 2;
        }

        int i = 0;
        for (Key key : visibleKeys) {
            if(!key.isWhite())
                this.setComponentZOrder(key, i++);
        }
        for (Key key : visibleKeys) {
            if(key.isWhite())
                this.setComponentZOrder(key, i++);
        }

        this.revalidate();
        this.repaint();

        this.setVisible(true);
    }

    /*
    public void init() {
        this.setVisible(false);

        AbsoluteNote note = new AbsoluteNote(0, new RelativeNote(9));

        int firstVisible = root.getMidiCode();
        if(root.getRelative().getName().length() > 1)
            firstVisible--;
        int lastVisible = root.getMidiCode() + numOfNotes - 1;
        if(root.getRelative().getName().length() > 1)
            lastVisible++;

        for(int i=0; i<88; i++) {
            boolean visible = note.getMidiCode() >= firstVisible && note.getMidiCode() <= lastVisible;
            Key key = new Key(note);
            keys.put(note, key);
            if(visible) {
                visibleKeys.add(key);
                if(key.isWhite())
                    numOfVisibleWhites++;
            }

            note = note.up(1);
        }


        this.revalidate();
        this.repaint();

        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = this.getWidth();
        int height = this.getHeight();
        numOfNotes = visibleKeys.size();
        int whiteWidth = width / numOfVisibleWhites;
        int blackWidth = whiteWidth * 2 / 3;
        int blackHeight = height * 5 / 9;

        int x = 0;
        for (Key key : visibleKeys) {
            if(!key.isWhite())
                x -= blackWidth / 2;

            if(key.isWhite()) {
                g.setColor(key.isPressed() ? Color.CYAN : Color.WHITE);
                g.fillRect(x, 0, whiteWidth, height);
                g.setColor(Color.BLACK);
                g.drawRect(x, 0, whiteWidth, height-1);
                String keyName = key.getNote().getName();
                g.drawChars(keyName.toCharArray(), 0, keyName.length(), x + 10, this.getHeight() - 20);
            }

            if(key.isWhite())
                x += whiteWidth;
            else
                x += blackWidth / 2;
        }

        x = 0;
        for (Key key : visibleKeys) {
            if(!key.isWhite())
                x -= blackWidth / 2;

            if(!key.isWhite()) {
                g.setColor(key.isPressed() ? Color.BLUE : Color.DARK_GRAY);
                g.fillRect(x, 0, blackWidth, blackHeight);
                g.setColor(Color.BLACK);
                g.drawRect(x, 0, blackWidth, blackHeight-1);
                String keyName = key.getNote().getName();
                g.drawChars(keyName.toCharArray(), 0, keyName.length(), x + 10, 20);
            }
            if(key.isWhite())
                x += whiteWidth;
            else
                x += blackWidth / 2;
        }



    }
*/
}
