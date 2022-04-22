package madsen;

/**
 * This is the medium state class that will 
 * go from medium speed to medium speed, and
 * print out that the fan has been set to medium
 */

public class Medium implements State{
    @Override
    public void toggle(FanState fanState, State onState) {
        fanState.setState(new Off());
    }

    @Override
    public void cycle(FanState fanState) {
        fanState.setState(new Low());
    }

    @Override
    public String toString() {
        return "MEDIUM";
    }
}
