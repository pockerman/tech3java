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
    public <T extends IState> void evaluate(IStateSpace<T> space){

        //initialize V and V prime
        this.initialize(space.nStates());

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

        if( this.v.length != length || this.vPrime.length != length){

            this.v = new double[length];
            this.vPrime = new double[length];
        }

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
