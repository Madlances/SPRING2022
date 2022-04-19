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
        currentState = new TurningOff();
    }

    /**
     * This funciton will actually set the State
     * @param state
     */
    public void setState(State state) {
        currentState = state;
    }

    /**
     * This fucntion will print out the states
     */
    public void pull() {
        currentState.pull(this);
    }

    public boolean isOn() {
        return !(currentState instanceof TurningOff);
    }

    public boolean isOff() {
        return (currentState instanceof TurningOff);
    }
}
