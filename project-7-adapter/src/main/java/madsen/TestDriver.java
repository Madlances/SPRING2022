package madsen;
/**
 * @author Kassandra Madsen
 * CS 3450 Section X01
 * Project 7 - Adapter pattern
 */

import java.util.Scanner;

/**
 * This is our main class that will display the shapes from the shape class
 */
public class TestDriver 
{
    /**
     * This will output the shape the user inputs
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shape shape = null;

        System.out.println("Would you like the Point, Line, Rectangle, or Circle shape?");
        while (shape == null) {
            String nextLine = scanner.nextLine().toLowerCase();
            if (nextLine.equals("point")) {
                shape = new Point();
            } else if (nextLine.equals("line")) {
                shape = new Line();
            } else if (nextLine.equals("rectangle")) {
                shape = new Rectangle();
            } else if (nextLine.equals("circle")) {
                shape = new XXCircleAdapter();
            } else {
                System.out.println("I'm sorry but that is not a valid shape, please choose Point, Line, Rectangle, or Circle");
            }
        }

        while (true) {
            System.out.println("Would you like to set location, get location, display, fill, set color, or undisplay the shape? Type quit when you are done");
            String nextLine = scanner.nextLine().toLowerCase();
            if (nextLine.equals("set location")) {
                shape.setLocation();
            } else if (nextLine.equals("get location")) {
                shape.getLocation();
            } else if (nextLine.equals("display")) {
                shape.display();
            } else if (nextLine.equals("undisplay")) {
                shape.undisplay();
            } else if (nextLine.equals("fill")) {
                shape.fill();
            } else if (nextLine.equals("set color")) {
                shape.setColor();
            } else if (nextLine.equals("quit")) {
                break;
            } else {
                System.out.print("\nI'm sorry but that is not an option.\n");
            }
        }
        scanner.close();
    }
}
