package rl;

import java.util.Collections;

/**
 * Two-arrays based iterative policy evaluation for
 * policy estimation
 */
public class ValueFunctionIterativePolicyEvaluation {


    /**
     * Constructor
     */
    public ValueFunctionIterativePolicyEvaluation(IterativePolicyEvaluationParams params){

        this.params = new IterativePolicyEvaluationParams();
        IterativePolicyEvaluationParams.copy(params, this.params);
    }

    /**
     * Returns the reward factor
     * @return
     */
    public double getReward(){
        return this.params.reward;
    }

    /**
     * Returns the discount factor
     */
    public double getGamma(){
        return this.params.gamma;
    }


    /**
     * Returns the value function for the given state
     */
    public double valueFunction(IState state){
        return this.v[state.getId()];
    }


    /**
     * Run the evaluation
     */
    public <T extends IState> void evaluate(IStateSpace<T> space){

        //initialize V and V prime
        this.initialize(space.nStates());


        long numItrs = 0;

        while(true) {

            double delta = 0.0;

            if (params.showItrs) {
                System.out.println("At iteration " + numItrs);
                numItrs++;
            }

            // loop over the states
            for (int s = 0; s < space.nStates(); ++s) {

                //get the state
                IState state = space.getState(s);


                // the state is not terminal
                if (!state.isTerminal()) {

                    double oldV = v[state.getId()];

                    double weightedSum = 0.0;

                    for (int a = 0; a < state.nActions(); a++) {

                        IAction action =state.getAction(a);
                        IState stateAfterAction = state.applyAction(a);
                        double actionProb = space.transitionDynamics(stateAfterAction, this.params.reward, state, action);
                        double nextStateValue = v[stateAfterAction.getId()];
                        weightedSum += actionProb * nextStateValue;
                    }


                    double stateSumVal = state.getReward() + this.params.gamma * weightedSum;
                    this.vPrime[state.getId()] = stateSumVal;

                    delta = Math.max(delta, Math.abs(oldV - stateSumVal));
                }
            }


            // after sweeping all states set V = Vprime
            this.v = this.vPrime;

            if (delta - params.tol < 0.0) {
                System.out.println("Policy evaluation finished");
                break;
            }
        }

    }

    /**
     * Zero V and V prime
     */
    public final void zero(){

        for (int i = 0; i < this.v.length; i++) {

            this.v[i] = 0.0;
            this.vPrime[i] = 0.0;

        }
    }

    /**
     * Initialize V and V prime to zero
     */
    protected final void initialize(int length){

        this.v = new double[length];
        this.vPrime = new double[length];
        this.zero();
    }

    /**
     * Parameters used by the algorithm
     */
    private IterativePolicyEvaluationParams params;

    /**
     * Array holding the old values
     */
    private double[] v;


    /**
     *  Array holding the updated values
     */
    private double[] vPrime;
}
