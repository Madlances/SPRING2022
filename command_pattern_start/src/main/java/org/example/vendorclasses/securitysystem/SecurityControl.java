package org.example.vendorclasses.securitysystem;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class SecurityControl {
    private SecurityAlarmState alarmState = SecurityAlarmState.DISARMED;

    public void arm() {
        alarmState = SecurityAlarmState.ARMED;
        printAlarmState();
    }

    public void disarm() {
        alarmState = SecurityAlarmState.DISARMED;
        printAlarmState();
    }

    private void printAlarmState() {
        System.out.println("Security alarm is " + alarmState.name());
    }
}
