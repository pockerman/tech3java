package ml;

import algorithms.optimizers.ISupervisedOptimizer;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.LinearVectorPolynomial;

/**
 * Linear regression modelling
 */
public class LinearRegressor<DataSetType extends DenseMatrix > {

    /**
     * Constructor
     */
    public LinearRegressor(){

    }

    public void train(DataSetType dataSet, Vector y, ISupervisedOptimizer optimizer){
        optimizer.optimize(dataSet, y, this.polynomial);
    }

    /**
     * The object that represents the linear polynomial
     */
    LinearVectorPolynomial polynomial;
}
