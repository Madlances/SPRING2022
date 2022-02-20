package madsen.commands;

import madsen.vendorclasses.Thermostat;

/**
 * This class will implment the Command class to
 * incrment the temperature when it's turned on and
 * decrement the temperature when it's turned off
 */
public class ThermostatCommand implements Command{
    private final Thermostat thermostat;
    private int temperature;

    /**
     * Our constructor creates a new Thermostat
     */
    public ThermostatCommand() {
        this.thermostat = new Thermostat();
    }

    /**
     * This function will increment the temperature
     */
    @Override
    public void on() {
        temperature = thermostat.getTemperature();
        thermostat.setTemperature(temperature + 1);
    }

    /**
     * This function will decrement the temperature
     */
    @Override
    public void off() {
        temperature = thermostat.getTemperature();
        thermostat.setTemperature(temperature - 1);
    }
}
