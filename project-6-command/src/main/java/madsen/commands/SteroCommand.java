package madsen.commands;

import madsen.vendorclasses.stereo.Stereo;
import madsen.vendorclasses.stereo.StereoMode;

/**
 * This class will implment the Command class to
 * go through the modes and turn the stero on or off
 * and set the volume
 */
public class SteroCommand implements Command{
    private final Stereo stereo;
    private int volume = 11;

    /**
     * Our constructor will create a new stereo
     */
    public SteroCommand() {
        this.stereo = new Stereo();
    }

    /**
     * This function will turn the stereo on and set the volume
     * and cycle through each mode if the button is pressed while
     * the stereo is already on
     */
    @Override
    public void on() {
        stereo.on();
        stereo.setVolume(volume);
        if (stereo.getMode() == StereoMode.RADIO) {
            stereo.setDvd();
        }

        if (stereo.getMode() == StereoMode.DVD) {
            stereo.setCd();
        }

        if (stereo.getMode() == StereoMode.CD) {
            stereo.setRadio();
        }
    }

    /**
     * This function will turn the stereo off
     */
    @Override
    public void off() {
        stereo.off();
    }
}
