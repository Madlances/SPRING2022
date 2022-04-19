package madsen;

/**
 * This class implements from the command class
 * that when pressed on, it sets the fan to medium, and
 * when pressed off, it turns off the fan
 */

public class ButtonTwo implements Command{

    public Medium mediumState;
    public FanState fanState;
    public TurningOff turningOff;

    /**
     * Our constructor to get the fanstate
     * @param fanState
     */
    public ButtonTwo(FanState fanState) {
        this.mediumState = new Medium();
        this.fanState = fanState;
        this.turningOff = new TurningOff();
    }

    /**
     * sets the fan to medium
     */
    @Override
    public void on() {
         fanState.setState(mediumState);
         mediumState.pull(fanState);
    }

    /**
     * turns the fan off
     */
    @Override
    public void off() {
        fanState.setState(turningOff);
        turningOff.pull(fanState);
    }
    
}
