package madsen;

/**
 * This is the High state class that will 
 * go from High speed to medium speed, and
 * print out that the fan has been set to high
 */

public class High implements State{
    @Override
    public void toggle(FanState fanState, State onState) {
        fanState.setState(new Off());
    }

    @Override
    public void cycle(FanState fanState) {
        fanState.setState(new Medium());
    }

    @Override
    public String toString() {
        return "HIGH";
    }
}
