package madsen;

/**
 * This is our remote control slot class that will handle where the buttons go.
 * This code was given from project 6
 */

public enum RemoteControlSlot {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private final int slotNumber;

    RemoteControlSlot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
