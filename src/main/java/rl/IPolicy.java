package rl;

/**
 * General interface for deriving Policies
 */
public interface IPolicy {


    /**
     * Add an action for the given state
     * @param state
     * @param action
     */
    void addAction(IState state, IAction action);

    /**
     * Get the action associated with the given state
     * @param state The state
     * @return IAction
     */
    IAction getAction(IState state);
}
