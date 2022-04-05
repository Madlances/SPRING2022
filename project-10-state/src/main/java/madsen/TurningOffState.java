package madsen;

/**
 * This class overrides the pull function and sets the state to the next state,
 * and prints out its state
 */
public class TurningOffState implements State{
    @Override
    public void pull(FanPullChain fanPullChain) {
        fanPullChain.setState(new LowState());
        System.out.println("turning off");
    }
}
