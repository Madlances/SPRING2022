package madsen.commands;

import madsen.vendorclasses.Light;

/**
 * This class will implment the Command class to
 * turn the lights on or off
 */
public class LightCommand implements Command {
    private final Light light;

    /**
     * Our constructor will create a new light
     */
    public LightCommand() {
        this.light = new Light();
    }

    /**
     * This function will turn the light on
     */
    @Override
    public void on() {
        light.on();
    }

    /**
     * This function will turn the light off
     */
    @Override
    public void off() {
        light.off();
    }
}
