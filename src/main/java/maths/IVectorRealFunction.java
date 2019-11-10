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
}
