package madsen.commands;

import madsen.vendorclasses.garagedoor.GarageDoor;
import madsen.vendorclasses.garagedoor.GarageDoorState;

/**
 * This class will implment the Command class to
 * open or close the garage
 */
public class GarageDoorCommand implements Command{
    private final GarageDoor garageDoor;

    /**
     * Our constructor will create a new garage door
     */
    public GarageDoorCommand() {
        this.garageDoor = new GarageDoor();
    }

    /**
     * This function will open the garage and
     * f the ON button is pressed a second time while the garage is in the OPEN state,
     * assume that the garage door was still on the way to the OPEN position, and 
     * change the state of the garage door to STOPPED
     * If the ON button is pressed while the garage is STOPPED, set it back to OPEN
     */
    @Override
    public void on() {
        garageDoor.up();

        if (garageDoor.getGarageDoorState() == GarageDoorState.UP) {
            garageDoor.stop();
        }

        if (garageDoor.getGarageDoorState() == GarageDoorState.STOPPED) {
            garageDoor.up();
        }
    }

    /**
     * This function will close the garage and
     * If the OFF button is pressed a second time while the garage is in the CLOSED state,
     * assume that the garage door was still on the way to the CLOSED position,
     * and change the state of the garage door to STOPPED
     * If the OFF button is pressed while the garage is STOPPED, set it back to CLOSED
     */
    @Override 
    public void off() {
        garageDoor.down();

        if (garageDoor.getGarageDoorState() == GarageDoorState.DOWN) {
            garageDoor.stop();
        }

        if (garageDoor.getGarageDoorState() == GarageDoorState.STOPPED) {
            garageDoor.down();
        }
    }
}
