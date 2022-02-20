package org.example.commands;

import org.example.vendorclasses.Light;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A sample implementation of a Command class demonstrating how a command class could talk to one of the
 *              provided vendor classes
 * */
public class LightCommand implements Command {
    private final Light light;

    public LightCommand() {
        this.light = new Light();
    }

    @Override
    public void on() {
        light.on();
    }

    @Override
    public void off() {
        light.off();
    }
}
