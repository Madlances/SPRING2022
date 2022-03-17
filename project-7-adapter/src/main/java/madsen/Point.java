package madsen;

public class Point implements Shape{

    public void display() {
        System.out.println("You have the shape Point displayed");
    }

    public void fill() {
        System.out.println("You have filled in the shape Point");
    }

    public void undisplay() {
        System.out.println("You have the shape Point undisplayed");
    }
}