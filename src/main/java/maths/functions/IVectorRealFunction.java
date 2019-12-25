package maths.functions;

import datastructs.interfaces.IVector;
import datastructs.maths.Vector;

public interface IVectorRealFunction<VectorType> extends IRealFunction<VectorType> {


    /**
     * Returns the gradients with respect to the coefficients at the given data point
     */
    IVector<Double> gradidents(IVector<Double> data);

    /**
     * Compute the gradients with respect to the coefficients
     */
    IVector<Double> coeffGradients(IVector<Double> data);

    /**
     * Returns the gradient
     */
    double gradient(int i, IVector<Double> data);

    /**
     * Returns the gradient with respect to the i-th coeff
     */
    double coeffGradient(int i, IVector<Double> data);


}
