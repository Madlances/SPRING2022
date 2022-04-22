package madsen;

import java.util.ArrayList;
import java.util.List;

/**
 * This is our remote control class that will handle set the buttons to the desired slot.
 * This code was given from project 6
 */

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

    public void pressButton(RemoteControlSlot remoteControlSlot) {
        RemoteControlSlotFunction slot = controlSlots.get(remoteControlSlot.getSlotNumber() - 1);
        System.out.printf("Toggling button for \"%s\" (Slot %d)\n", slot.getName(), remoteControlSlot.getSlotNumber());
        slot.toggleButtonPress();
    }
}
