package rl;

public interface IAction {


    /**
     * The state that the action leads to
     */
    void addTransitionToState(IState state);

    /**
     * Returns the state to transition to
     */
    IState getTransitionToState();
}
