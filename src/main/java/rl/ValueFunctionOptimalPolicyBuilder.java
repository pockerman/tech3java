package rl;


/**
 * Build and maintain an optimal policy from an optimal
 * value function
 */
public class ValueFunctionOptimalPolicyBuilder<StateSpace extends IStateSpace, PolicyType extends IPolicy> implements
        IOptimalPolicyBuilder<StateSpace, IPolicy, ValueFunctionIterativePolicyEvaluation> {

    /**
     * Build the optimal policy from the given EvaluatorType
     */
    public void  buildFrom(final StateSpace stateSpace, final ValueFunctionIterativePolicyEvaluation evaluatorType){


        PolicyType policy = null;

        final double gamma = evaluatorType.getGamma();
        final double R = evaluatorType.getReward();

        // loop over the states in the state space
        for (int s = 0; s < stateSpace.nStates(); s++) {

            IState state = stateSpace.getState(s);

            IAction maxAction = null;
            double maxReward = 0.0;

            // loop over the actions in this state
            for(int a=0; a<state.nActions(); ++a){

                // get the action
                IAction action = state.getAction(a);

                IState stateAfterAction = action.getTransitionToState();
                double actionValue = stateSpace.transitionDynamics(stateAfterAction, R, state, action)*(R + gamma*evaluatorType.valueFunction(stateAfterAction));

                if(actionValue > maxReward) {
                    maxAction = action;
                }
            }

            // we are done for this state add the action with the maximum reward
            policy.addAction(state, maxAction);
        }
    }

    /**
     * Returns the PolicyType
     */
    public PolicyType getPolicy(){

        return null;
    }



}
