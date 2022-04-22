package madsen;

/**
 * This is our state class, given from project 10,
 * it will call fanstate here so the subclasses can
 * set the right state
 */

public interface State {
    void toggle(FanState fanState, State onState);
    void cycle(FanState fanState);
}
