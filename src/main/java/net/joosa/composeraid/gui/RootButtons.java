package net.joosa.composeraid.gui;

import net.joosa.composeraid.music.RelativeNote;

import javax.swing.*;

public class RootButtons extends ButtonGroup {
    public void setSelection(RelativeNote note) {
        for (AbstractButton button : this.buttons) {
            RootButton b = (RootButton) button;
            if(b.getNote().equals(note))
                this.setSelected(b.getModel(), true);
        }
    }

    public RelativeNote getRoot() {
        for (AbstractButton button : this.buttons) {
            RootButton b = (RootButton) button;
            if(b.getModel().isSelected())
                return b.getNote();
        }
        return new RelativeNote(0);
    }
}
