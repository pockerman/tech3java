package rl;

public interface IState {

    /**
     * Returns the name of the state
     */
    String getName();


    /**
     * Returns the id of the state
     */
    int getId();


    /**
     * Add an action to be executed when at this state
     */
    void addAction(IAction action);
}
