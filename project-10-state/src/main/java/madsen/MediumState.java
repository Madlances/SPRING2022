package madsen;

/**
 * This class overrides the pull function and sets the state to the next state,
 * and prints out its state
 */
public class MediumState implements State{
   @Override
   public void pull(FanPullChain fanPullChain) {
    fanPullChain.setState(new HighState());
    System.out.println("medium speed");
   }
}
