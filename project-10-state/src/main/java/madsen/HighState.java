package madsen;

/**
 * This class overrides the pull function and sets the state to the next state,
 * and prints out its state
 */
public class HighState implements State{
    @Override
    public void pull(FanPullChain fanPullChain) {
        fanPullChain.setState(new TurningOffState());
        System.out.println("high speed");
    }
}
