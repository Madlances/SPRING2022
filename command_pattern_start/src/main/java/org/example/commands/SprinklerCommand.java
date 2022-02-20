package org.example.commands;

import org.example.vendorclasses.Sprinkler;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A sample implementation of a Command class demonstrating how a command class could talk to one of the
 *              provided vendor classes
 * */
public class SprinklerCommand implements Command {
    private final Sprinkler sprinkler;

    public SprinklerCommand() {
        this.sprinkler = new Sprinkler();
    }

    @Override
    public void on() {
        sprinkler.waterOn();
    }

    @Override
    public void off() {
        sprinkler.waterOff();
    }
}
