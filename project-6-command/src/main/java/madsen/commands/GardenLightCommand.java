package madsen.commands;

import madsen.vendorclasses.GardenLight;

/**
 * This class will implment the Command class to
 * turn the garden light on or off
 */
public class GardenLightCommand implements Command{
    private final GardenLight gardenLight;

    /**
     * Our constructor will create a new garden light
     */
    public GardenLightCommand() {
        this.gardenLight = new GardenLight();
    }

    /**
     * This function will turn the garden light on
     */
    @Override
    public void on() {
        gardenLight.manualOn();
    }

    /**
     * This function will turn the garden light off
     */
    @Override
    public void off() {
        gardenLight.manualOff();
    }
}
