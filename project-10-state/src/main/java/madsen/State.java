package madsen;

/**
 * This calls will have the subclasses implement pull to set the states
 * as well as print out their states
 */
public interface State {
    void pull(FanPullChain fanPullChain);
}
