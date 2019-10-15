package rl;

public interface IOptimalPolicyBuilder<StateSpaceType, PolicyType, EvaluatorType> {


    /**
     * Build the optimal policy from the given EvaluatorType
     */
    void  buildFrom(final StateSpaceType stateSpace, final EvaluatorType evaluatorType);

    /**
     * Returns the PolicyType
     */
    PolicyType getPolicy();
}
