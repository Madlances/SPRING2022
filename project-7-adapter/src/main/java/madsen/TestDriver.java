package madsen;

import java.util.Scanner;

public class TestDriver 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point point = new Point();
        Line line = new Line();
        Rectangle rectangle = new Rectangle();
        XXCircleAdapter xxCircleAdapter = new XXCircleAdapter();
        System.out.println("Would you like the Point, Line, Rectangle, or Circle shape?");
        String shape = scanner.nextLine().toLowerCase();
        while (true) {
            System.out.println("Next, would you like to set location, get location, display, fill, set color, or undisplay the shape? Type quit when you are done");
            String nextLine = scanner.nextLine().toLowerCase();
            if (shape.equals("point") && nextLine.equals("set location")) {
                System.out.println("I'm sorry that is not an option for the shape Point, please choose Circle if you would like to set a location");
            }
            else if (shape.equals("line") && nextLine.equals("set location")) {
                System.out.println("I'm sorry that is not an option for the shape Line, please choose Circle if you would like to set a location");
            }
            else if (shape.equals("rectangle") && nextLine.equals("set location")) {
                System.out.println("I'm sorry that is not an option for the shape Rectangle, please choose Circle if you would like to set a location");
            }
            else if (shape.equals("circle") && nextLine.equals("set location")) {
                xxCircleAdapter.setLocation();
            }
            else if (shape.equals("point") && nextLine.equals("get location")) {
                System.out.println("I'm sorry that is not an option for the shape Point, please choose Circle if you would like to get a location");
            }
            else if (shape.equals("line") && nextLine.equals("get location")) {
                System.out.println("I'm sorry that is not an option for the shape Line, please choose Circle if you would like to get a location");
            }
            else if (shape.equals("rectangle") && nextLine.equals("get location")) {
                System.out.println("I'm sorry that is not an option for the shape Rectangle, please choose Circle if you would like to get a location");
            }
            else if (shape.equals("circle") && nextLine.equals("get location")) {
                xxCircleAdapter.getLocation();
            }
            else if (shape.equals("point") && nextLine.equals("display")) {
                point.display();
            }
            else if (shape.equals("line") && nextLine.equals("display")) {
                line.display();
            }
            else if (shape.equals("rectangle") && nextLine.equals("display")) {
                rectangle.display();
            }
            else if (shape.equals("circle") && nextLine.equals("display")) {
                xxCircleAdapter.display();
            }
            else if (shape.equals("point") && nextLine.equals("fill")) {
                point.fill();
            }
            else if (shape.equals("line") && nextLine.equals("fill")) {
                line.fill();
            }
            else if (shape.equals("rectangle") && nextLine.equals("fill")) {
                rectangle.fill();
            }
            else if (shape.equals("circle") && nextLine.equals("fill")) {
                xxCircleAdapter.fill();
            }
            else if (shape.equals("point") && nextLine.equals("set color")) {
                System.out.println("I'm sorry that is not an option for the shape Point, please choose Circle if you would like to set a color");
            }
            else if (shape.equals("line") && nextLine.equals("set color")) {
                System.out.println("I'm sorry that is not an option for the shape Line, please choose Circle if you would like to set a color");
            }
            else if (shape.equals("rectangle") && nextLine.equals("set color")) {
                System.out.println("I'm sorry that is not an option for the shape Rectangle, please choose Circle if you would like to set a color");
            }
            else if (shape.equals("circle") && nextLine.equals("set color")) {
                xxCircleAdapter.setColor();
            }
            else if (shape.equals("point") && nextLine.equals("undisplay")) {
                point.undisplay();
            }
            else if (shape.equals("line") && nextLine.equals("undisplay")) {
                line.undisplay();
            }
            else if (shape.equals("rectangle") && nextLine.equals("undisplay")) {
                rectangle.undisplay();
            }
            else if (shape.equals("circle") && nextLine.equals("undisplay")) {
                xxCircleAdapter.undisplay();
            }
            else if (nextLine.equals("quit")) {
                break;
            }
            else {
                System.out.println("\nI'm sorry but that is not an option. Please choose something else\n");
                System.out.println("Would you like to set location, get location, display, fill, set color, or undisplay the shape? Type quit when you are done");
            }
        }
        scanner.close();
    }
}
