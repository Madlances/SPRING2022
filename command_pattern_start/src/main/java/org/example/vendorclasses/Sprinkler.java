package org.example.vendorclasses;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class Sprinkler {
    private boolean powerState = false;

    public void waterOn() {
        powerState = true;
        printPowerState();
    }

    public void waterOff() {
        powerState = false;
        printPowerState();
    }

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("Sprinkler is %s\n", stateString);
    }
}
