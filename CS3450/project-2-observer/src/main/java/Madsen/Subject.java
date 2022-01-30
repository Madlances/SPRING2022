package Madsen;

/**
 * This class is will have the functions attach, detach and notify.
 * These functions will be needed in other classes that implement it.
 * Also, attach and detach will take in an observer as a parameter, so we can add or remove observers.
 * I'm using the Pull method of the Observer Pattern.
 */
public interface Subject <T> {
    public void Attach(Observer<T> o);
    public void Detach(Observer<T> o);
    public void Notify();
}
