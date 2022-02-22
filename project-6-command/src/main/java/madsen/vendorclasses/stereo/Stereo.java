package madsen.vendorclasses.stereo;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class Stereo {
    private int volume = 5;
    private StereoMode mode = StereoMode.CD;
    private boolean powerState = false;

    public void on() {
        powerState = true;
        printPowerState();
    }

    public void off() {
        powerState = false;
        printPowerState();
    }

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("CeilingLight is %s\n", stateString);
    }

    public boolean getPowerState() {
        return powerState;
    }

    public StereoMode getMode() {
        return mode;
    }

    public void setCd() {
        this.mode = StereoMode.CD;
        System.out.println("Stereo set to Cd");
    }

    public void setDvd() {
        this.mode = StereoMode.DVD;
        System.out.println("Stereo set to Dvd");
    }

    public void setRadio() {
        this.mode = StereoMode.RADIO;
        System.out.println("Stereo set to Radio");
    }

    public void setVolume(int level) {
        volume = level;
        System.out.println("Stereo set volume to " + volume);
    }

    public int getVolume() {
        return volume;
    }

}
