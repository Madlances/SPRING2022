package org.example.remotecontrol;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: An enumeration to more easily control the slot values on the remote control. You do not need to modify
 *              this code for the assignment, but you are welcome to play with it. Just make sure it still works when
 *              you submit the project!
 * */
public enum RemoteControlSlot {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int slotNumber;

    RemoteControlSlot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
