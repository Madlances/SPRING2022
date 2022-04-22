package madsen;

/**
 * This is the low state class that will 
 * go from low speed to medium speed, and
 * print out that the fan has been set to low
 */

public class Low implements State{
    @Override
    public void toggle(FanState fanState, State onState) {
        fanState.setState(new Off());
    }

    @Override
    public void cycle(FanState fanState) {
        fanState.setState(new Off());
    }

    @Override
    public String toString() {
        return "LOW";
    }
}
