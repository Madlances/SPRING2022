package madsen.commands;

import madsen.vendorclasses.fan.CeilingFan;

/**
 * This class will implment the Command class to
 * turn the ceiling fan on or off
 */
public class CeilingFanCommand implements Command{
    private final CeilingFan ceilingFan;

    /**
     * Our constructor will create a new ceiling fan
     */
    public CeilingFanCommand() {
        this.ceilingFan = new CeilingFan();
    }

    /**
     * This function will turn on the fan at its current speed. 
     * If the on button is pressed again while the fan is already on, 
     * then the speed should increase, or loop around to the lowest speed in the case
     * that the highest speed was already set.
     * 1st on button press – turn the fan on at LOW speed (assuming that is the first speed)
     * 2nd on button press – change the speed of the fan to MEDIUM
     * 3rd on button press – change the speed of the fan to HIGH
     * 4th on button press – change the speed of the fan to LOW again.
     */
    @Override
    public void on() {
        ceilingFan.low();
        ceilingFan.medium();
        ceilingFan.high();
        ceilingFan.low();
    }

    /**
     * This function will turn the fan off, leaving it
     * at the current speed setting
     */
    @Override
    public void off() {
        ceilingFan.getSpeed();
        ceilingFan.off();
    }
}
