package rl;

/**
 * Interface to define a contract for a StateSpace
 * @param <T>
 */
public interface IStateSpace<T extends IState> {


    /**
     * Returns the number of states the space has
     */
    int nStates();


    /**
     * Returns the i-th state
     */
    IState getState(int i);


    /**
     * Add a state in the space
     */
    void addState(IState state);


    /**
     * Returns the probability getting at state sprime with reward r
     * when at state s and executing action a
     * @param sprime The state to get to
     * @param r The reward anticipated
     * @param s the state currently on
     * @param a The action required from s to sprime
     * @return probability estimate
     */
    double transitionDynamics(IState sprime, double r, IState s, IAction a);
}
