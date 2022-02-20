package org.example.vendorclasses;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class Tv {
    private boolean powerState = false;
    private int channel = 3;
    private int volume = 5;

    public void on() {
        powerState = true;
        printPowerState();
    }

    public void off() {
        powerState = false;
        printPowerState();
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.printf("TV channel set to %d\n", channel);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.printf("TV volume set to %d\n", volume);
    }

    private void printPowerState() {
        String stateString = powerState ? "on" : "off";
        System.out.printf("TV is %s\n", stateString);
    }
}
