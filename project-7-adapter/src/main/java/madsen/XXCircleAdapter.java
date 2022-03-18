package madsen;

/**
 * This is our XXCircleAdapater function that will extend Shape it will implement display, fill, and undisplay.
 * It will also use the default setLocation, getLocation, and setColor from Shape
 */
public class XXCircleAdapter extends Shape{

    XXCircle xxCircle;

    public XXCircleAdapter() {
        this.xxCircle = new XXCircle();
    }

    /**
     * This function will set the location of the shape (for now we are just printing out a statement to indicate that) by using the XXCircle class
     * and overriding this function.
     */
    @Override
    public void setLocation() {
        xxCircle.setLocation();
    }

    /**
     * This function will get the location of the shape (for now we are just printing out a statement to indicate that) by using the XXCircle class
     * and overriding this function.
     */
    @Override
    public void getLocation() {
        xxCircle.getLocation();
    }

    /**
     * This function will display the shape (for now we are just printing out a statement to indicate that) by using the XXCircle class
     */
    public void display() {
        xxCircle.displaylt();
    }

    /**
     * This function will fill the shape (for now we are just printing out a statement to indicate that) by using the XXCircle class
     */
    public void fill() {
        xxCircle.filllt();
    }

    /**
     * This function will set the color of the shape (for now we are just printing out a statement to indicate that) by using the XXCircle class
     * and overriding this function.
     */
    @Override
    public void setColor() {
        xxCircle.setltsColor();
    }

    /**
     * This function will undisplay the shape (for now we are just printing out a statement to indicate that) by using the XXCircle class
     */
    public void undisplay() {
        xxCircle.undisplaylt();
    }
}