package maths;

import datastructs.maths.Vector;

public interface IVectorRealFunction<VectorType> extends IRealFunction<VectorType> {

    /**
     * Returns the number of coefficients
     */
    int numCoeffs();

    /**
     * Returns the coefficients of the vector function
     */
    Vector getCoeffs();

    /**
     * Returns the gradients with respect to the coefficients at the given data point
     */
    Vector gradidents(Vector data);

    /**
     * Returns the gradient with respect to the i-th coeff
     */
    double gradient(int i, Vector data);
}
