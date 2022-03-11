package madsen.commands;

import madsen.vendorclasses.securitysystem.SecurityControl;

/**
 * This class will implment the Command class to
 * arm or disaarm the system
 */
public class SecurityControlCommand implements Command{
    private final SecurityControl securityControl;

    /**
     * Our constructor will create a new security control
     */
    public SecurityControlCommand() {
        this.securityControl = new SecurityControl();
    }

    /**
     * This function will arm the system
     */
    @Override
    public void on() {
        securityControl.arm();
    }

    /**
     * This function will disarm the system
     */
    @Override
    public void off() {
        securityControl.disarm();
    }
}
