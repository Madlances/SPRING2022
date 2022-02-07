package madsen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DriverFactory driverFactory = null;
        System.out.print("Do you have a Low or High Res Driver? (l or h): ");
        String driver = scanner.nextLine().toLowerCase();
        while(true) {
            System.out.print("Type 'd' to print a document,\n'w' to draw a widget,\n or 'q' to quit: ");
            String line = scanner.nextLine().toLowerCase();
            if (driver.equals("l") && line.equals("d")) {
                driverFactory = new LowResDriverFactory();
                System.out.println("");
                System.out.println("Printing a Document using a " + driverFactory.createPrintDriver().print() + "\n");
            } else if (driver.equals("l") && line.equals("w")) {
                driverFactory = new LowResDriverFactory();
                System.out.println("");
                System.out.println("Drawing a Widget using a " + driverFactory.createDisplayDriver().display() + "\n");
            } else if (driver.equals("h") && line.equals("d")) {
                driverFactory = new HighResDriverFactory();
                System.out.println("");
                System.out.println("Printing a Document using a " + driverFactory.createPrintDriver().print() + "\n");
            } else if (driver.equals("h") && line.equals("w")) {
                driverFactory = new HighResDriverFactory();
                System.out.println("");
                System.out.println("Drawing a Widget using a " + driverFactory.createDisplayDriver().display() + "\n");
            }
            else if (line.equals("q")) {
                break;
            }
                else {
                System.out.println("\nI'm sorry but that is not an option. Please only type in 'w','d', or 'q'.\n");
                System.out.print("Type 'd' to print a document,\n'w' to draw a widget,\n or 'q' to quit: ");
            }
        }
        scanner.close();
    }
}
