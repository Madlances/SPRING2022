package madsen.commands;

import madsen.vendorclasses.HotTub;

/**
 * This class will implment the Command class to
 * turn on the hottub, jets, and circulation and
 * then turn everything off
 */
public class HotTubCommand implements Command{
    private final HotTub hotTub;

    /**
     * Our constructor will create a new hottub
     */
    public HotTubCommand() {
        this.hotTub = new HotTub();
    }

    /**
     * This function will turn on the hottub, jets, and circulation
     */
    @Override
    public void on() {
        hotTub.jetsOn();
        hotTub.circulate();
    }

    /**
     * This function will turn off everything
     */
    @Override
    public void off() {
        hotTub.jetsOff();
        hotTub.circulate();
    }
}
