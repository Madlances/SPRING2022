package org.example.vendorclasses;

public class Light {
    private boolean powerState = false;

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

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("Light is %s\n", stateString);
    }
}
