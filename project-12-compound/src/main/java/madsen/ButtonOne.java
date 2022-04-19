package madsen;

/**
 * This class implements from the command class
 * that when pressed on, it sets the fan to high, and
 * when pressed off, it turns off the fan
 */
public class ButtonOne implements Command{

    public High highState;
    public FanState fanState;
    public TurningOff turningOff;

    /**
     * Our constructor to get the fanstate
     * @param fanState
     */
    public ButtonOne(FanState fanState) {
        this.highState = new High();
        this.fanState = fanState;
        this.turningOff = new TurningOff();
    }

    /**
     * sets the fan state to high
     */
    @Override
    public void on() {
        fanState.setState(highState);
        highState.pull(fanState);
    }

    /**
     * turns off the fan
     */
    @Override
    public void off() {
        fanState.setState(turningOff);
        turningOff.pull(fanState);
    }
}
