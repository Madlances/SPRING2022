package madsen;

/**
 * This is the turning off state class that will 
 * go from turning off speed to medium speed, and
 * print out that the fan has been set to turning off
 */

public class TurningOff implements State{
    @Override
    public void pull(FanState fanState) {
        fanState.setState(new High());
        System.out.println("Fan is turning off");
    }
}
