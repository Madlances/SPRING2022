package org.example;

import org.example.commands.LightCommand;
import org.example.commands.SprinklerCommand;
import org.example.remotecontrol.RemoteControl;
import org.example.remotecontrol.RemoteControlSlot;

/**
 * Author: -- Your name here --
 * Project:
 * Description:
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
        System.out.println("Assigning the sprinklers to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Turbo Sprinklers", new SprinklerCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

        System.out.println("\nRe-assigning a Light to Slot 1");
        printSeparator();
        remoteControl.addCommandToSlot("Hallway Light", new LightCommand(), RemoteControlSlot.ONE);
        remoteControl.pushOnButton(RemoteControlSlot.ONE);
        remoteControl.pushOffButton(RemoteControlSlot.ONE);

    }

    public static void printSeparator() {
        System.out.println("--------------------------------------");
    }
}
