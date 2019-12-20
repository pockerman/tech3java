package ml.clustering;

import algorithms.utils.IterativAlgorithmController;
import maths.errorfunctions.IVectorErrorRealFunction;

public class KMeansInput {

    /**
     * Flag indicating if information messages should be printed
     * as the algorithm executes
     */
    public boolean showIterations = true;


    /**
     * The class that controls the iterations of the algorithm
     */
    public IterativAlgorithmController iterationContorller;
}
