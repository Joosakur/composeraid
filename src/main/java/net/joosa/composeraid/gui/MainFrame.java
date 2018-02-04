package net.joosa.composeraid.gui;

import net.joosa.composeraid.midi.DeviceManager;
import net.joosa.composeraid.music.AbsoluteNote;
import net.joosa.composeraid.music.RelativeNote;
import net.joosa.composeraid.music.keys.KeyType;
import net.joosa.composeraid.music.keys.MajorKey;
import net.joosa.composeraid.music.keys.NaturalMinorKey;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private ChordPanel chordPanel;
    private JPanel absKeyPanel;
    private JPanel rootButtonPanel;
    private RootButtons rootButtons;
    private JPanel keyButtonPanel;
    private KeyButtons keyButtons;

    public void init() throws MidiUnavailableException {
        this.setSize(1900, 768);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Keyboard keyboard = new Keyboard(
                new AbsoluteNote(48),
                38
        );
        keyboard.setSize(this.getWidth(), 300);
        keyboard.setPreferredSize(new Dimension(this.getWidth(), 300));
        keyboard.init();
        this.add(keyboard, BorderLayout.PAGE_END);

        chordPanel = new ChordPanel(new RelativeNote(0), new MajorKey(), keyboard);
        this.add(chordPanel, BorderLayout.CENTER);

        absKeyPanel = new JPanel();
        rootButtonPanel = new JPanel();
        rootButtons = new RootButtons();
        keyButtonPanel = new JPanel();
        keyButtons = new KeyButtons();
        for(int i=0; i<12; i++) {
            RootButton rootButton = new RootButton(new RelativeNote(i));
            rootButton.setPreferredSize(new Dimension(100, 100));
            rootButton.addChangeListener((event) -> {
                if(rootButton.isSelected()) {
                    this.remove(chordPanel);
                    chordPanel = new ChordPanel(rootButton.getNote(), keyButtons.getKey(), keyboard);
                    this.add(chordPanel, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                }
            });
            rootButtonPanel.add(rootButton);
            rootButtons.add(rootButton);
        }
        rootButtons.setSelection(new RelativeNote(0));
        absKeyPanel.add(rootButtonPanel);

        KeyType[] keys = {new MajorKey(), new NaturalMinorKey()};
        for (KeyType key : keys) {
            KeyButton keyButton = new KeyButton(key);
            keyButton.addChangeListener((event) -> {
                if(keyButton.isSelected()) {
                    this.remove(chordPanel);
                    chordPanel = new ChordPanel(rootButtons.getRoot(), keyButton.getKey(), keyboard);
                    this.add(chordPanel, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                }
            });
            keyButtonPanel.add(keyButton);
            keyButtons.add(keyButton);
        }
        keyButtons.setSelection(new MajorKey());
        absKeyPanel.add(keyButtonPanel);
        this.add(absKeyPanel, BorderLayout.PAGE_START);

        this.addKeyListener(new KeyAdapter() {
            boolean sus = false;

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyPressed(e);
                if(!sus && e.getKeyChar() == 'z') {
                    try {
                        ShortMessage msg = new ShortMessage(ShortMessage.CONTROL_CHANGE, 0, 64, 127);
                        DeviceManager.getReceiver().send(msg, -1);
                        System.out.println("sustain on");
                        sus = true;
                    } catch (InvalidMidiDataException | MidiUnavailableException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyChar() == 'z') {
                    try {
                        ShortMessage msg = new ShortMessage(ShortMessage.CONTROL_CHANGE, 0, 64, 0);
                        DeviceManager.getReceiver().send(msg, -1);
                        System.out.println("sustain off");
                        sus = false;
                    } catch (InvalidMidiDataException | MidiUnavailableException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        this.setFocusable(true);
        this.setVisible(true);
    }


}

