package org.example.remotecontrol;

import org.example.commands.Command;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: An object to contain the button press functionality of the remote control. This object is interchangeable
 *              so new commands can be added to the different slots of the provided remote control. You do not need to
 *              modify any of the code in this class. Just make sure that it still works when you submit your project!
 * */
public class RemoteControlSlotFunction {
    private String name = "EMPTY SLOT";
    private Command command;

    public RemoteControlSlotFunction() {}

    public RemoteControlSlotFunction(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public void assignCommand(Command command) {
        this.command = command;
    }

    public void onButtonPress() {
        if (command != null) {
            command.on();
        } else {
            System.out.println("No command assigned to this slot");
        }
    }

    public void offButtonPress() {
        if (command != null) {
            command.off();
        } else {
            System.out.println("No command assigned to this slot");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
