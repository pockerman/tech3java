package ml.regression;

import datastructs.maths.DenseMatrixSet;
import maths.functions.LinearVectorPolynomial;

/**
 * Linear regression modelling
 */
public class LinearRegressor<DataSetType extends DenseMatrixSet<Double>> extends RegressorBase<DataSetType, LinearVectorPolynomial> {

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
