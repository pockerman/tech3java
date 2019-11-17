package ml;

import algorithms.optimizers.ISupervisedOptimizer;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.functions.LinearVectorPolynomial;

/**
 * Linear regression modelling
 */
public class LinearRegressor<DataSetType extends DenseMatrix > extends RegressorBase<DataSetType, LinearVectorPolynomial> {

    /**
     * Constructor
     */
    public LinearRegressor(int numFeatures){
        super(new LinearVectorPolynomial(numFeatures));
    }

    /**
     * Constructor
     */
    public LinearRegressor(LinearVectorPolynomial hypothesis){
        super(hypothesis);
    }

}
