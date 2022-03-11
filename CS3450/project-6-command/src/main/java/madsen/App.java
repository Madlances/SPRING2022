package madsen;

import madsen.commands.LightCommand;
import madsen.commands.SprinklerCommand;
import madsen.commands.SteroCommand;
import madsen.commands.ApplianceControlCommand;
import madsen.commands.CeilingFanCommand;
import madsen.commands.CeilingLightCommand;
import madsen.commands.FaucetControlCommand;
import madsen.commands.GarageDoorCommand;
import madsen.commands.GardenLightCommand;
import madsen.commands.HotTubCommand;
import madsen.commands.SecurityControlCommand;
import madsen.commands.ThermostatCommand;
import madsen.commands.TvCommand;
import madsen.remotecontrol.RemoteControl;
import madsen.remotecontrol.RemoteControlSlot;

/**
 * @author Kassandra Madsen
 * CS 3450 - x01
 * Project 6 - Command Pattern
 * */
public class App {

    public static void main( String[] args ) {
        RemoteControl remoteControl = new RemoteControl();

        /*
         * The two code blocks below are provided as a demonstration of how the remote control should be used.
         * Replace this code with your own commands to fill up the entire functionality of the remote
         * with the command classes that you create.
         * TODO: Replace the below blocks with your own tests
         * */
        System.out.println("Assigning the tv to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Tv", new TvCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nReassigning the Thermostat to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Thermostat", new ThermostatCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nAssigning the Sprinklers to Slot 2");
        printSeparator();
        remoteControl.addCommandToSlot("Sprinklers", new SprinklerCommand(), RemoteControlSlot.TWO);
        remoteControl.pushOnButton(RemoteControlSlot.TWO);
        remoteControl.pushOffButton(RemoteControlSlot.TWO);

        System.out.println("\nReassigning a Light to Slot 2");
        printSeparator();
        remoteControl.addCommandToSlot("Hallway Light", new LightCommand(), RemoteControlSlot.TWO);
        remoteControl.pushOnButton(RemoteControlSlot.TWO);
        remoteControl.pushOffButton(RemoteControlSlot.TWO);

        System.out.println("\nAssigning Garden Light to Slot 3");
        printSeparator();
        remoteControl.addCommandToSlot("Garden Light", new GardenLightCommand(), RemoteControlSlot.THREE);
        remoteControl.pushOnButton(RemoteControlSlot.THREE);
        remoteControl.pushOffButton(RemoteControlSlot.THREE);

        System.out.println("\nReassigning the Hot Tub to Slot 3");
        printSeparator();
        remoteControl.addCommandToSlot("Hot Tub", new HotTubCommand(), RemoteControlSlot.THREE);
        remoteControl.pushOnButton(RemoteControlSlot.THREE);
        remoteControl.pushOffButton(RemoteControlSlot.THREE);

        System.out.println("\nAssigning the Faucet to Slot 4");
        printSeparator();
        remoteControl.addCommandToSlot("Faucet", new FaucetControlCommand(), RemoteControlSlot.FOUR);
        remoteControl.pushOnButton(RemoteControlSlot.FOUR);
        remoteControl.pushOffButton(RemoteControlSlot.FOUR);

        System.out.println("\nReassigning the Ceiling Light to Slot 4");
        printSeparator();
        remoteControl.addCommandToSlot("Ceiling Light", new CeilingLightCommand(), RemoteControlSlot.FOUR);
        remoteControl.pushOnButton(RemoteControlSlot.FOUR);
        remoteControl.pushOffButton(RemoteControlSlot.FOUR);

        System.out.println("\nAssigning the Appliance Control to Slot 5");
        printSeparator();
        remoteControl.addCommandToSlot("Appliance Control", new ApplianceControlCommand(), RemoteControlSlot.FIVE);
        remoteControl.pushOnButton(RemoteControlSlot.FIVE);
        remoteControl.pushOffButton(RemoteControlSlot.FIVE);

        System.out.println("\nReassigning the Stereo to Slot 5");
        printSeparator();
        remoteControl.addCommandToSlot("Stereo", new SteroCommand(), RemoteControlSlot.FIVE);
        remoteControl.pushOnButton(RemoteControlSlot.FIVE);
        remoteControl.pushOffButton(RemoteControlSlot.FIVE);

        System.out.println("\nAssigning Security to Slot 6");
        printSeparator();
        remoteControl.addCommandToSlot("Security", new SecurityControlCommand(), RemoteControlSlot.SIX);
        remoteControl.pushOnButton(RemoteControlSlot.SIX);
        remoteControl.pushOffButton(RemoteControlSlot.SIX);

        System.out.println("\nReassigning Garage Door to Slot 6");
        printSeparator();
        remoteControl.addCommandToSlot("Garage Door", new GarageDoorCommand(), RemoteControlSlot.SIX);
        remoteControl.pushOnButton(RemoteControlSlot.SIX);
        remoteControl.pushOffButton(RemoteControlSlot.SIX);

        System.out.println("\nReassigning Ceiling Fan to Slot 6");
        printSeparator();
        remoteControl.addCommandToSlot("Ceiling Fan", new CeilingFanCommand(), RemoteControlSlot.SIX);
        remoteControl.pushOnButton(RemoteControlSlot.SIX);
        remoteControl.pushOffButton(RemoteControlSlot.SIX);
    }

    public static void printSeparator() {
        System.out.println("--------------------------------------");
    }
}