package madsen;

/**
 * This class is part of the command pattern that once this button is clicked
 * it will cycle through to the next speed. (Example:  If fan is at high, the next click 
 * will move the speed to medium.  The next click will move it to low.  The next click will move it to 
 * off. The click will move it to high, etc.)
 */
public class ButtonFour implements Command{
    public FanState fanState;
    public TurningOff turningOff;

    /**
     * Our constructor to get the fanstate
     * @param fanState
     */
    public ButtonFour(FanState fanState) {
        this.fanState = fanState;
        this.turningOff = new TurningOff();
    }

    /**
     * Our on function to cycle through the speeds
     */
    @Override
    public void on() {
        fanState.pull();
    }

    /**
     * Don't really need this function for Button 4 since it's cycling through, but we need it so
     * the parent class doesn't complain
     */
    @Override
    public void off() {
        fanState.setState(turningOff);
        turningOff.pull(fanState);
    }
}
