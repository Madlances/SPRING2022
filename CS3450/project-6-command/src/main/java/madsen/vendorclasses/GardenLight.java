package madsen.vendorclasses;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class GardenLight {
    private int duskTime = 700;
    private int dawnTime = 1900;
    private boolean powerState = false;

    public int getDuskTime() {
        return duskTime;
    }

    public void setDuskTime(int duskTime) {
        this.duskTime = duskTime;
        System.out.println("Dusk time set to" + duskTime);
    }

    public int getDawnTime() {
        return dawnTime;
    }

    public void setDawnTime(int dawnTime) {
        this.dawnTime = dawnTime;
        System.out.println("Dawn time set to" + dawnTime);
    }

    public void manualOn() {
        powerState = true;
        printPowerState();
    }

    public void manualOff() {
        powerState = false;
        printPowerState();
    }

    public boolean getPowerState() {
        printPowerState();
        return powerState;
    }

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("GardenLight is %s\n", stateString);
    }
}
