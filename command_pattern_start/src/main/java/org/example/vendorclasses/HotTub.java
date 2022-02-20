package org.example.vendorclasses;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class HotTub {
    private int temperature = 80;
    private boolean jetsState = false;
    private boolean circulationState = false;

    public void circulate() {
        circulationState = !circulationState;
        System.out.println("Circulation is " + (circulationState ? "ON" : "OFF"));
    }

    public void jetsOn() {
        jetsState = true;
        printJetState();
    }

    public void jetsOff() {
        jetsState = false;
        printJetState();
    }

    private void printJetState() {
        System.out.println("Jest are " + (jetsState ? "ON" : "OFF"));
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature set to " + temperature);
    }
}
