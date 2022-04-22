package madsen;

/**
 * This class implements from the command class
 * that when pressed on, it sets the fan to medium, and
 * when pressed off, it turns off the fan
 */

public class ButtonTwo implements Command{

    public FanState fanState;

    /**
     * Our constructor to get the fanstate
     * @param fanState
     */
    public ButtonTwo(FanState fanState) {
        this.fanState = fanState;
    }

    /**
     * toggles the fan state
     */
    @Override
    public void pressButton() {
        fanState.toggle(new Medium());
    }
}
