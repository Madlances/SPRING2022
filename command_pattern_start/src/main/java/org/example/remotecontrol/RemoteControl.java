package org.example.remotecontrol;

import java.util.ArrayList;
import java.util.List;

import org.example.commands.Command;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: The CEO of Home Automation or But, Inc. was also kind enough to send the source code of the remote control
 *              they want you to program all the commands to. You do not need to modify this code for the assignment, but
 *              you are welcome to play with it. Just make sure it still works when you submit!
 * */
public class RemoteControl {
    private static final int MAX_CONTROL_SLOTS = RemoteControlSlot.values().length;
    public List<RemoteControlSlotFunction> controlSlots;

    public RemoteControl() {
        initControlSlots();
    }

    private void initControlSlots() {
        controlSlots = new ArrayList<>(MAX_CONTROL_SLOTS);
        for (int i = 0; i < MAX_CONTROL_SLOTS; i++) {
            controlSlots.add(new RemoteControlSlotFunction());
        }
    }

    public void addCommandToSlot(String remoteCommandName, Command command, RemoteControlSlot remoteControlSlot) {
        RemoteControlSlotFunction newSlotFunction = new RemoteControlSlotFunction(remoteCommandName, command);
        controlSlots.add(remoteControlSlot.getSlotNumber() - 1, newSlotFunction);
        System.out.printf("Added %s to remote slot %d\n", remoteCommandName, remoteControlSlot.getSlotNumber());
    }

    public void pushOnButton(RemoteControlSlot remoteControlSlot) {
        RemoteControlSlotFunction slot = controlSlots.get(remoteControlSlot.getSlotNumber() - 1);
        System.out.printf("Pressing ON button for \"%s\" (Slot %d)\n", slot.getName(), remoteControlSlot.getSlotNumber());
        slot.onButtonPress();
    }

    public void pushOffButton(RemoteControlSlot remoteControlSlot) {
        RemoteControlSlotFunction slot = controlSlots.get(remoteControlSlot.getSlotNumber() - 1);
        System.out.printf("Pressing OFF button for \"%s\" (Slot %d)\n", slot.getName(), remoteControlSlot.getSlotNumber());
        slot.offButtonPress();
    }
}
