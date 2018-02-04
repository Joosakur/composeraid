package net.joosa.composeraid.gui;

import net.joosa.composeraid.music.keys.KeyType;
import net.joosa.composeraid.music.keys.MajorKey;

import javax.swing.*;

public class KeyButtons extends ButtonGroup {

    public void setSelection(KeyType key) {
        for (AbstractButton button : this.buttons) {
            KeyButton b = (KeyButton) button;
            if(b.getKey().equals(key))
                this.setSelected(b.getModel(), true);
        }
    }

    public KeyType getKey() {
        for (AbstractButton button : this.buttons) {
            KeyButton b = (KeyButton) button;
            if(button.getModel().isSelected())
                return b.getKey();
        }
        return new MajorKey();
    }
}
