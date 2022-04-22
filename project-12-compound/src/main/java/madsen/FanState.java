package madsen;

/**
 * From project 10, this is our fanstate class
 */

public class FanState {
    public State currentState; // instantiate the currentState

    /**
     * This function will set the first state to the LowState
     */
    public FanState() {
        currentState = new Off();
    }

    /**
     * This funciton will actually set the State
     * @param state
     */
    public void setState(State state) {
        System.out.println("Fan has been set to " + state.toString());
        currentState = state;
    }

    public void toggle(State onState) {
        currentState.toggle(this, onState);
    }

    public void cycle() {
        currentState.cycle(this);
    }
}
