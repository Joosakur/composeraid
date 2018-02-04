package net.joosa.composeraid.midi;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;

public class DeviceManager {

    private static Receiver receiver;


    public static Receiver getReceiver() throws MidiUnavailableException {
        if(receiver == null)
            openReceiver();
        return receiver;
    }

    private static void openReceiver() throws MidiUnavailableException {
        for (MidiDevice.Info info : MidiSystem.getMidiDeviceInfo()) {
            if(info.getName().equalsIgnoreCase("java") &&
                    info.getDescription().equalsIgnoreCase("external midi port")) {
                MidiDevice device = MidiSystem.getMidiDevice(info);
                device.open();
                receiver = device.getReceiver();
                return;
            }
        }

        throw new MidiUnavailableException("No suitable midi receiver found");
    }
}
