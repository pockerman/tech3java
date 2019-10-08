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
}
