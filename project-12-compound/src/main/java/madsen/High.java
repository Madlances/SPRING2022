package madsen;

/**
 * This is the High state class that will 
 * go from High speed to medium speed, and
 * print out that the fan has been set to high
 */

public class High implements State{

    @Override
    public void pull(FanState fanState) {
        fanState.setState(new Medium());
        System.out.println("Fan has been set to High");
    }
    
}
