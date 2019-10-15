package rl;

public interface IState {


    /**
     * Returns the id of the state
     */
    int getId();


    /**
     * Add an action to be executed when at this state
     */
    void addAction(IAction action);


    /**
     * Number of actions for this IState
     */
    int nActions();


    /**
     * Returns the state that this state transitions to when the action with the given local id is aplied
     * @param actionId Action local id
     * @return IState
     */
    IState applyAction(int actionId);

    /**
     * Return the probability of taking the action with the given index
     * whilst at this state
     */
    double getActionProbability(int actionIdx);

    /**
     * Returns the i-th action that is possible when at this state
     * @param i
     * @return IAction The i-th action when at this state
     */
    IAction getAction(int i);

    /**
     * Returns the reward achieved in this state
     */
    double getReward();

    /**
     * Returns true if the state is a terminal state
     */
    boolean isTerminal();
}
