package madsen;

/**
 * This is the medium state class that will 
 * go from medium speed to medium speed, and
 * print out that the fan has been set to medium
 */

public class Medium implements State{

    @Override
    public void pull(FanState fanState) {
        fanState.setState(new Low());
        System.out.println("Fan has been set to Medium");
    }
    
}
