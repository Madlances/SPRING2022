package org.example.vendorclasses;

/**
 * Author: Chris Brewer
 * Date: Feb 15, 2022
 * Description: A class provided by a vendor of Home Automation or Bust, Inc.
 * */
public class FaucetControl {
    private boolean valveState = false;

    public void openValve() {
        valveState = true;
    }

    public void closeValve() {
        valveState = false;
    }

    private void printValveState() {
        String stateString = valveState ? "open" : "closed";
        System.out.printf("Faucet valve is %s\n", stateString);
    }
}
