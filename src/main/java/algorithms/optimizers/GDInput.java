package algorithms.optimizers;

import algorithms.AlgorithmInput;
import maths.IVectorErrorRealFunction;

/**
 * Input class for Gradient Descent algorithm
 */
public class GDInput extends AlgorithmInput {

    /**
     * The learning rate used
     */
    public double eta;

    /**
     * Use momentum implementation
     */
    public boolean useMomentum=false;

    /**
     * The error function used
     */
    public IVectorErrorRealFunction errF;

}
