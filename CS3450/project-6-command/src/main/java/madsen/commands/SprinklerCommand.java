package madsen.commands;

import madsen.vendorclasses.Sprinkler;

/**
 * This class will implment the Command class to
 * turn the water on when they turn it on and
 * turn the water off when tey turn it off
 */
public class SprinklerCommand implements Command {
    private final Sprinkler sprinkler;

    /**
     * Our constructor will create a new sprinkler
     */
    public SprinklerCommand() {
        this.sprinkler = new Sprinkler();
    }

    /**
     * This function will turn the sprinkler on
     */
    @Override
    public void on() {
        sprinkler.waterOn();
    }

    /**
     * This function will turn the sprinkler off
     */
    @Override
    public void off() {
        sprinkler.waterOff();
    }
}