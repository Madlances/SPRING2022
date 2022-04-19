package madsen;

/**
 * This is the low state class that will 
 * go from low speed to medium speed, and
 * print out that the fan has been set to low
 */

public class Low implements State{

    @Override
    public void pull(FanState fanState) {
        fanState.setState(new TurningOff());
        System.out.println("Fan has been set to Low");
    }
    
}
