package Madsen;

/**
 * This is our Observer Class.
 * It will update the Average, Change10, and Selections through the Subject class.
 */
public interface Observer<T> {
    public void update();
}
