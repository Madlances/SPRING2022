package madsen.commands;

import madsen.vendorclasses.ApplianceControl;

/**
 * This class will implment the Command class to
 * turn the appliance control on or off
 */
public class ApplianceControlCommand implements Command{
    private final ApplianceControl applianceControl;

    /**
     * Our constructor will create a new appliance control
     */
    public ApplianceControlCommand() {
        this.applianceControl = new ApplianceControl();
    }

    /**
     * This function turns on the appliance control
     */
    @Override
    public void on() {
        applianceControl.on();
    }

    /**
     * This function turns off te appliance control
     */
    @Override
    public void off() {
        applianceControl.off();
    }
}
