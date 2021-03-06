package madsen;

import java.util.Scanner;

/**
 * @author Kassandra Madsen
 * CS 3450 Section X01
 * Project 12 - Compound Pattern
 */
public class App 
{
    /**
     * This function will be our main tester of the program. It will also
     * program the buttons to the right fan speeds
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FanState fanState = new FanState();
        ButtonOne buttonOne = new ButtonOne(fanState);
        ButtonTwo buttonTwo = new ButtonTwo(fanState);
        ButtonThree buttonThree = new ButtonThree(fanState);
        ButtonFour buttonFour = new ButtonFour(fanState);

        RemoteControl remoteControl = new RemoteControl();
        System.out.println("Welcome to the Ceiling Fan Program!");
        System.out.println("We will start assigning the buttons to the Fan Speeds");
        System.out.println("Assigning Fan Speed 'High' to Button 1");
        printSeparator();
        remoteControl.addCommandToSlot("High Speed", buttonOne, RemoteControlSlot.ONE);
        printSeparator();

        System.out.println("Assigning Fan Speed to 'Medium' to Button 2");
        printSeparator();
        remoteControl.addCommandToSlot("Medium Speed", buttonTwo, RemoteControlSlot.TWO);
        printSeparator();

        System.out.println("Assigning Fan Speed to 'Low' to Button 3");
        printSeparator();
        remoteControl.addCommandToSlot("Low Speed", buttonThree, RemoteControlSlot.THREE);
        printSeparator();

        System.out.println("Assigning Fan Cycle to to Button 4");
        printSeparator();
        remoteControl.addCommandToSlot("Cycle", buttonFour, RemoteControlSlot.FOUR);
        printSeparator();

        while (true) {
            System.out.print("Would you like to Press Button 1, Button 2, Button 3, or Button 4. (Press 'q' to quit)\n");
            String nextLine = scanner.nextLine().toLowerCase();
            if (nextLine.equals("button 1")) {
                remoteControl.pressButton(RemoteControlSlot.ONE);
            } else if (nextLine.equals("button 2")) {
                remoteControl.pressButton(RemoteControlSlot.TWO);
            } else if (nextLine.equals("button 3")) {
                remoteControl.pressButton(RemoteControlSlot.THREE);
            } else if (nextLine.equals("button 4")) {
                remoteControl.pressButton(RemoteControlSlot.FOUR);
            }
            else if (nextLine.equals("q")) {
                break;
            }
            else {
                System.out.print("\nI'm sorry but that is not an option. Please choose Button 1, Button 2, Button 3, or Button 4\n");
            }
        }
        scanner.close();
    }

    /**
     * This function is just extra to give some nice ui look
     */
    public static void printSeparator() {
        System.out.println("--------------------------------------");
    }
}
