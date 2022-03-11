package madsen.commands;

import madsen.vendorclasses.FaucetControl;

/**
 * This class will implment the Command class to
 * open or close the faucet
 */
public class FaucetControlCommand implements Command{
    private final FaucetControl faucetControl;

    /**
     * Our constructor will create a new faucet
     */
    public FaucetControlCommand() {
        this.faucetControl = new FaucetControl();
    }

    /**
     * This will open the faucet
     */
    @Override
    public void on() {
        faucetControl.openValve();
    }

    /**
     * This will close the faucet
     */
    @Override 
    public void off() {
        faucetControl.closeValve();
    }
}
