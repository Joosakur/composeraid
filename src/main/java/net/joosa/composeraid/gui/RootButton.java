package net.joosa.composeraid.gui;

import net.joosa.composeraid.music.RelativeNote;

import javax.swing.*;

public class RootButton extends JToggleButton {
    private RelativeNote note;

    public RootButton(RelativeNote note) {
        super(note.getName());
        this.note = note;
    }

    public RelativeNote getNote() {
        return note;
    }
}
