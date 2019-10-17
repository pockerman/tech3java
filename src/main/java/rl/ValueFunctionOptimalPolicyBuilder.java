package rl;


/**
 * Build and maintain an optimal policy from an optimal
 * value function
 */
public class ValueFunctionOptimalPolicyBuilder<StateSpace extends IStateSpace, PolicyType extends IPolicy>{


    /**
     * Constructor
     * @param builder
     */
    public ValueFunctionOptimalPolicyBuilder(IPolicyBuilder<PolicyType> builder){

        this.policy = builder.build();
        this.maxRewardInitial = 0.0;
    }

    /**
     * Constructor
     * @param builder
     */
    public ValueFunctionOptimalPolicyBuilder(IPolicyBuilder<PolicyType> builder, double maxRewardInitial){

        this.policy = builder.build();
        this.maxRewardInitial = maxRewardInitial;
    }

    /**
     * Build the optimal policy from the given EvaluatorType
     */
    public void  buildFrom(final StateSpace stateSpace, final ValueFunctionIterativePolicyEvaluation evaluatorType){

        final double gamma = evaluatorType.getGamma();
        final double R = evaluatorType.getReward();

        // loop over the states in the state space
        for (int s = 0; s < stateSpace.nStates(); s++) {

            IState state = stateSpace.getState(s);

            IAction maxAction = null;
            double maxReward = this.maxRewardInitial; //-(Double.MAX_VALUE - 1);

            // loop over the actions in this state
            for(int a=0; a<state.nActions(); ++a){

                // get the action
                IAction action = state.getAction(a);

                IState stateAfterAction = action.getTransitionToState();

                double transitionDynmicsValue = stateSpace.transitionDynamics(stateAfterAction, R, state, action);
                double valueFunctionValue = evaluatorType.valueFunction(stateAfterAction);
                double actionValue = transitionDynmicsValue*(R + gamma*valueFunctionValue);

                if(actionValue > maxReward) {
                    maxReward = actionValue;
                    maxAction = action;
                }
            }

            // we are done for this state add the action with the maximum reward
            this.policy.addAction(state, maxAction);
        }
    }

    /**
     * Returns the PolicyType
     */
    public PolicyType getPolicy(){

        return this.policy;
    }


    private PolicyType policy;
    private double maxRewardInitial;

}
