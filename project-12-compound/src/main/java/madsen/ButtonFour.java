package madsen;

/**
 * This class is part of the command pattern that once this button is clicked
 * it will cycle through to the next speed. (Example:  If fan is at high, the next click 
 * will move the speed to medium.  The next click will move it to low.  The next click will move it to 
 * off. The click will move it to high, etc.)
 */
public class ButtonFour implements Command{
    public FanState fanState;

    /**
     * Our constructor to get the fanstate
     * @param fanState
     */
    public ButtonFour(FanState fanState) {
        this.fanState = fanState;
    }

    /**
     * cycles the fan state
     */
    @Override
    public void pressButton() {
        fanState.cycle();
    }
}
