package madsen;

/**
 * This is our Rectangle function that will extend Shape it will implement display, fill, and undisplay.
 * It will also use the default setLocation, getLocation, and setColor from Shape
 */
public class Rectangle extends Shape{

    /**
     * This function will display the shape (for now we are just printing out a statement to indicate that)
     */
    public void display() {
        System.out.println("You have the shape Rectangle displayed");
    }

    /**
     * This function will fill the shape (for now we are just printing out a statement to indicate that)
     */
    public void fill() {
        System.out.println("You have filled in the shape Rectangle");
    }

    /**
     * This function will undisplay the shape (for now we are just printing out a statement to indicate that)
     */
    public void undisplay() {
        System.out.println("You have the shape Rectangle undisplayed");
    }
}