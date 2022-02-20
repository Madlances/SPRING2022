package org.example.vendorclasses;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class CeilingLight {
    private boolean powerState = false;
    private boolean dimmed = false;

    public void on() {
        powerState = true;
        printPowerState();
    }

    public void off() {
        powerState = false;
        printPowerState();
    }

    public boolean getPowerState() {
        return powerState;
    }

    public void dim() {
        dimmed = !dimmed;
        System.out.printf("Ceiling Light is %sdim\n", dimmed ? "" : "not ");
    }

    public boolean isDimmed() {
        return dimmed;
    }

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("CeilingLight is %s\n", stateString);
    }
}
