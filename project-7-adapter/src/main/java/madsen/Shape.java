package madsen;

/**
 * This is our Shape that is abstract, so any class that extends off of this class will
 * have to have the functions display, fill, and undisplay. Only the Circle class will
 * use setLocation, getLocation, and setColor
 */
public abstract class Shape {
    
    /**
     * This function will set the location of the shape (for now we are just printing out a statement to indicate that)
     */
    public void setLocation() {
        System.out.println("You have set the location of this Shape");
    }

    /**
     * This function will get the location of the shape (for now we are just printing out a statement to indicate that)
     */
    public void getLocation() {
        System.out.println("You have the location of this Shape");
    }

    /**
     * This function is our display function that will have the other classes implement
     */
    public abstract void display();

    /**
     * This is our fill function that will have the other classes implement
     */
    public abstract void fill();

    /**
     * This function will set the color of the shape (for now we are just printing out a statement to indicate that)
     */
    public void setColor() {
        System.out.println("You have set the color of this Shape");
    };

    /**
     * This our undisplay function that will have the other classes implement
     */
    public abstract void undisplay();
}