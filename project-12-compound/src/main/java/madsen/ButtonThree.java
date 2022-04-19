package madsen;

/**
 * This class implements from the command class
 * that when pressed on, it sets the fan to low, and
 * when pressed off, it turns off the fan
 */

public class ButtonThree implements Command{

    public Low lowState;
    public FanState fanState;
    public TurningOff turningOff;

    /**
     * our constructor to get the fan state
     */
    public ButtonThree(FanState fanState) {
        this.lowState = new Low();
        this.fanState = fanState;
        this.turningOff = new TurningOff();
    }

    /**
     * sets the fan to low
     */
    @Override
    public void on() {
        fanState.setState(lowState);
        lowState.pull(fanState);
    }

    /**
     * sets the fan to high
     */
    @Override
    public void off() {
        fanState.setState(turningOff);
        turningOff.pull(fanState);
    }
    
}
