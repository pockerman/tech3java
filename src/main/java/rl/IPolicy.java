package rl;

public interface IPolicy {

    /**
     * Returns the value of the policy for the given action when at the given state
     * @param action The action to be performed
     * @param state The state at which the action takes place
     * @return
     */
    double value(IAction action, IState state);
}
