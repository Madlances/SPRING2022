/**
 * @author Kassandra Madsen
 * CS 3450 - X01
 * Project 3 - Decorator Pattern
 */
package madsen;

import java.util.Scanner;

/**
 * This is our Main class that will print out the various crust, cheese, and toppings
 * for the user to make their own pizza. As they pick out each option, it will print out what they have choosen,
 * as well as print out the total price at the very end when they are done.  
 */
public class Main 
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in); // user input
        Integer currentChoice = null; // want to override this for 0-2 cheeses and infinite toppings

        // where they start making their pizza
        // Crust Section
        System.out.println("Welcome to the Pizza Shop!");
        System.out.println("");
        System.out.println("Select Crust:");
        System.out.println("");
        System.out.println("   1) Thin - $1\n   2) Traditional - $2\n   3) Stuffed - $3\n");
        System.out.print("Choice: ");
        Pizza pizza = null; // want to override this to make any kind of pizza
        while(true) {
            Integer choice = scanner.nextInt();
            if (choice == 1) {
                pizza = new ThinCrust();
                System.out.println("");
                System.out.println(pizza.getDescription());
                break;
            } else if (choice == 2) {
                pizza = new TraditionalCrust();
                System.out.println("");
                System.out.println(pizza.getDescription());
                break;
            } else if (choice == 3) {
                pizza = new StuffedCrust();
                System.out.println("");
                System.out.println(pizza.getDescription());
                break;
            } else {
                System.out.println("");
                System.out.println("I'm sorry but that is not a choice. Please select another choice.");
                System.out.print("Choice: ");
            }
        }

        // Cheese Sections
        System.out.println("");
        System.out.println("What kind of Cheese?");
        System.out.println("");
        System.out.println("   1) Mozzarella - $0.10\n   2) Parmesan - $0.10\n   3) Ricotta - $0.12\n   4) None\n");
        System.out.print("Choice: ");
        while(true) {
            Integer choice = scanner.nextInt();
            if (choice == 1) {
                pizza = new Mozzarella(pizza);
                System.out.println("");
                System.out.println(pizza.getDescription());
                currentChoice = choice;
                break;
            } else if (choice == 2) {
                pizza = new Parmesan(pizza);
                System.out.println("");
                System.out.println(pizza.getDescription());
                currentChoice = choice;
                break;
            } else if (choice == 3) {
                pizza = new Ricotta(pizza);
                System.out.println("");
                System.out.println(pizza.getDescription());
                currentChoice = choice;
                break;
            } else if (choice == 4) {
                currentChoice = choice;
                break;
            } else {
                System.out.println("");
                System.out.println("I'm sorry but that is not a choice. Please select another choice.");
                System.out.print("Choice: ");
            }
        }

        if (currentChoice != 4) {
            System.out.println("");
            System.out.println("Another Cheese?");
            System.out.println("");
            System.out.println("   1) Mozzarella - $0.10\n   2) Parmesan - $0.10\n   3) Ricotta - $0.12\n   4) Done\n");
            System.out.print("Choice: ");
            while(true) {
                currentChoice = scanner.nextInt();
                if (currentChoice == 1) {
                    pizza = new Mozzarella(pizza);
                    System.out.println("");
                    System.out.println(pizza.getDescription());
                    break;
                } else if (currentChoice == 2) {
                    pizza = new Parmesan(pizza);
                    System.out.println("");
                    System.out.println(pizza.getDescription());
                    break;
                } else if (currentChoice == 3) {
                    pizza = new Ricotta(pizza);
                    System.out.println("");
                    System.out.println(pizza.getDescription());
                    break;
                } else if (currentChoice == 4) {
                    break;
                } else {
                    System.out.println("");
                    System.out.println("I'm sorry but that is not a choice. Please select another choice.");
                    System.out.print("Choice: ");
                }
            }
        }

        // Topping Section
        currentChoice = -1; // make sure to clear out current choice
        while (currentChoice != 4) {
            System.out.println("");
            System.out.println("Pick your Toppings: ");
            System.out.println("");
            System.out.println("   1) Pepperoni - $0.50\n   2) Pineapple - $0.30\n   3) Chicken - $0.60\n   4) Done\n");
            System.out.print("Choice: ");
            while(true) {
                currentChoice = scanner.nextInt();
                if (currentChoice == 1) {
                    pizza = new Pepperoni(pizza);
                    System.out.println("");
                    System.out.println(pizza.getDescription());
                    break;
                } else if (currentChoice == 2) {
                    pizza = new Pineapple(pizza);
                    System.out.println("");
                    System.out.println(pizza.getDescription());
                    break;
                } else if (currentChoice == 3) {
                    pizza = new Chicken(pizza);
                    System.out.println("");
                    System.out.println(pizza.getDescription());
                    break;
                } else if (currentChoice == 4) {
                    break;
                } else {
                    System.out.println("");
                    System.out.println("I'm sorry but that is not a choice. Please select another choice.");
                    System.out.print("Choice: ");
                }
            }
        }
        scanner.close();

        System.out.println("");
        System.out.print("Your Pizza is: " + pizza.getDescription() + " - $" + String.format("%.2f", pizza.cost()) + "\n");
        System.out.println("");;
        System.out.println("Thank you for coming!");
    }
}
