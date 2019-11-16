package maths.functions;

import datastructs.maths.Vector;

public interface IVectorRealFunction<VectorType> extends IRealFunction<VectorType> {



    /**
     * Returns the gradients with respect to the coefficients at the given data point
     */
    Vector gradidents(Vector data);

    /**
     * Compute the gradients with respect to the coefficients
     */
    Vector coeffGradients(Vector data);

    /**
     * Returns the gradient
     */
    double gradient(int i, Vector data);

    /**
     * Returns the gradient with respect to the i-th coeff
     */
    double coeffGradient(int i, Vector data);


}
