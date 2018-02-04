package net.joosa.composeraid.gui;

import net.joosa.composeraid.music.keys.KeyType;

import javax.swing.*;

public class KeyButton extends JToggleButton {
    private KeyType key;

    public KeyButton(KeyType key) {
        super(key.getScaleType().getName());
        this.key = key;
    }

    public KeyType getKey() {
        return key;
    }
}
