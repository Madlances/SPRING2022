package org.example.vendorclasses.fan;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class CeilingFan {
    private boolean powerState = false;
    private FanSpeed fanSpeed = FanSpeed.LOW;

    public void off() {
        powerState = false;
        printPowerState();
    }

    public FanSpeed getSpeed() {
        printFanSpeed();
        return fanSpeed;
    }

    public void low() {
        powerState = true;
        fanSpeed = FanSpeed.LOW;
        printFanSpeed();
    }

    public void medium() {
        powerState = true;
        fanSpeed = FanSpeed.MEDIUM;
        printFanSpeed();
    }

    public void high() {
        powerState = true;
        fanSpeed = FanSpeed.HIGH;
        printFanSpeed();
    }

    private void printFanSpeed() {
        System.out.println("Current fan speed is " + fanSpeed.name());
    }

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("CeilingLight is %s\n", stateString);
    }

    public boolean isOn() {
        return powerState;
    }
}
