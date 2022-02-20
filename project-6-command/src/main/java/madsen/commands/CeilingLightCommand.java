package madsen.commands;

import madsen.vendorclasses.CeilingLight;

/**
 * This class will implment the Command class to
 * ceiling light on or off (also dim it as well)
 */
public class CeilingLightCommand implements Command{
    private final CeilingLight ceilingLight;

    /**
     * Our constructor will create a new ceiling light
     */
    public CeilingLightCommand() {
        this.ceilingLight = new CeilingLight();
    }

    /**
     * This function will turn the ceiling light on. If it's on dim it.
     * If its on and already dimed then undim it
     */
    @Override
    public void on() {
        ceilingLight.on();
        if (ceilingLight.getPowerState() == true) {
            ceilingLight.dim();
        } 
        
        if (ceilingLight.getPowerState() == true && ceilingLight.isDimmed() == true) {
            ceilingLight.dim();
        }
    }

    /**
     * This function will turn off the ceiling light
     */
    @Override
    public void off() {
        ceilingLight.off();
    }
}
