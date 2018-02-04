package net.joosa.composeraid;

import net.joosa.composeraid.gui.MainFrame;

import javax.sound.midi.MidiUnavailableException;

public class Main {

    public static void main(String[] args) {
        MainFrame main = new MainFrame();
        try {
            main.init();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            return;
        }
    }
}
