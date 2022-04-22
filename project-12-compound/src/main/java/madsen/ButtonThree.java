package madsen;

/**
 * This class implements from the command class
 * that when pressed on, it sets the fan to low, and
 * when pressed off, it turns off the fan
 */

public class ButtonThree implements Command{

    public FanState fanState;

    /**
     * our constructor to get the fan state
     */
    public ButtonThree(FanState fanState) {
        this.fanState = fanState;
    }

    /**
     * toggles the fan state
     */
    @Override
    public void pressButton() {
        fanState.toggle(new Low());
    }
}
