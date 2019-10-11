package rl;

/**
 * Parameters for the IterativePolicyEvaluation algorithm
 */
public class IterativePolicyEvaluationParams {


    /**
     * Copy the parameters from source to dst
     */
    public static final void copy(IterativePolicyEvaluationParams src, IterativePolicyEvaluationParams dst){

        dst.tol = src.tol;
        dst.reward = src.reward;
        dst.gamma = src.gamma;
        dst.showItrs = src.showItrs;
    }

    /**
     * tolerance parameter for stopping the iteration
     */
    public double tol;

    /**
     * Reward
     */
    public double reward;


    /**
     * Discount parameter
     */
    public double gamma;

    /**
     * Whether iterations are shown
     */
    public boolean showItrs = true;
}
