package rl;

/**
 * Two-arrays based iterative policy evaluation for
 * policy estimation
 */
public class IterativePolicyEvaluation {


    /**
     * Constructor
     */
    public IterativePolicyEvaluation(IterativePolicyEvaluationParams params){

        this.params = new IterativePolicyEvaluationParams();
        IterativePolicyEvaluationParams.copy(params, this.params);
    }


    /**
     * Run the evaluation
     */
    public void evaluate(IStateSpace<IState> space){


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
