package madsen;

/**
 * This class implements from the command class
 * that when pressed on, it sets the fan to high, and
 * when pressed off, it turns off the fan
 */
public class ButtonOne implements Command{
    public FanState fanState;

    /**
     * Our constructor to get the fanstate
     * @param fanState
     */
    public ButtonOne(FanState fanState) {
        this.fanState = fanState;
    }

    /**
     * toggles the fan state
     */
    @Override
    public void pressButton() {
        fanState.toggle(new High());
    }
}
