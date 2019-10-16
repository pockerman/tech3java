package rl;

/**
 * General interface for describing transition dynamics between states
 */
public interface ITransitionDynamics {


    /**
     * Returns the probability getting at state sprime with reward r
     * when at state s and executing action a
     * @param sprime The state to get to
     * @param r The reward anticipated
     * @param s the state currently on
     * @param a The action required from s to sprime
     * @return probability estimate
     */
    double pr(IState sprime, double r, IState s, IAction a);
}
