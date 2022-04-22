package madsen;

/**
 * This is the turning off state class that will 
 * go from turning off speed to medium speed, and
 * print out that the fan has been set to turning off
 */

public class Off implements State{
    @Override
    public void toggle(FanState fanState, State onState) {
        fanState.setState(onState);
    }

    @Override
    public void cycle(FanState fanState) {
        fanState.setState(new High());
    }

    @Override
    public String toString() {
        return "OFF";
    }
}
