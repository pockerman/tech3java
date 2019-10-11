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


    /**
     * Number of actions for this IState
     */
    int nActions();


    /**
     * Returns the state that this state transitions to when the action with the given local id is apllied
     * @param actionId Action local id
     * @return IState
     */
    IState applyAction(int actionId);


    /**
     * Return the probability of taking the action with the given name
     * whilst at this state
     */
    double getActionProbability(String actionName);


    /**
     * Return the probability of taking the action with the given name
     * whilst at this state
     */
    double getActionProbability(int actionIdx);


    /**
     * Returns the sum: p()*[r + gamma*V(s')]
     */
    double getStateSumValue(double reward, double discount, double[] previousStates);


    /**
     * Returns the reward achieved in this state
     */
    double getReward();

    /**
     * Returns the number of states this state can transition to
     */
    int nStateToTransitions();


    /**
     * Returns the i-th IState this IState can transition to
     */
    IState getStateToTransition(int i);


    /**
     * Returns true if the state is a terminal state
     */
    boolean isTerminal();
}
