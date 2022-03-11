package madsen.commands;

import madsen.vendorclasses.Tv;

/**
 * This class will implment the Command class to
 * turn the tv on when they turn it on and set a volume and
 * turn the tv off when they turn it off
 */
public class TvCommand implements Command{
    private final Tv tv;
    private int volume = 7;

    /**
     * Our constructor will create a new tv
     */
    public TvCommand() {
        this.tv = new Tv();
    }

    /**
     * This function will turn the tv on
     */
    @Override
    public void on() {
        tv.on();
        tv.setVolume(volume);
    }

    /**
     * This function will turn the tv off
     */
    @Override
    public void off() {
        tv.off();
    }
}
