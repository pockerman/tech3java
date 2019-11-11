package maths;

import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;

public interface IVectorErrorRealFunction {


    /**
     * Evaluate the error function using the given data, labels
     * @param data
     * @param labels
     * @return
     */
    double evaluate(DenseMatrix data, Vector labels);

    /**
     * Returns the gradients on the given data
     */
    Vector gradients(DenseMatrix data, Vector labels);


}
