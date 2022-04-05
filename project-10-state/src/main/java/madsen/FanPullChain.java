package madsen;

/**
 * This class is our Context that manages the states for the State class
 */
public class FanPullChain {
    private State currentState; // instantiate the currentState

    /**
     * This function will set the first state to the LowState
     */
    public FanPullChain() {
        currentState = new LowState();
    }

    /**
     * This funciton will actually set the State
     * @param state
     */
    public void setState(State state) {
        currentState = state;
    }

    /**
     * This function is from our original code, that will print out the states
     */
    public void pull() {
        currentState.pull(this);
    }
}
