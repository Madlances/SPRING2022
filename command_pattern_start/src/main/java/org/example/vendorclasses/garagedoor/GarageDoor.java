package org.example.vendorclasses.garagedoor;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class GarageDoor {
    private GarageDoorState garageDoorState = GarageDoorState.DOWN;
    private boolean lightState = false;

    public void up() {
        garageDoorState = GarageDoorState.UP;
        printDoorState();
    }

    public void down() {
        garageDoorState = GarageDoorState.DOWN;
        printDoorState();
    }

    public void stop() {
        garageDoorState = GarageDoorState.STOPPED;
        printDoorState();
    }

    public GarageDoorState getGarageDoorState() {
        return garageDoorState;
    }

    public void lightOn() {
        lightState = true;
        printLightState();
    }

    public void lightOff() {
        lightState = false;
        printLightState();
    }

    private void printLightState() {
        String stateString = lightState ? "on" : "off";
        System.out.printf("Garage door light is %s\n", stateString);
    }

    private void printDoorState() {
        System.out.printf("Garage door light is %s\n", garageDoorState.name());
    }
}
