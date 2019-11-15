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
    public LinearRegressor(int numFeatures){

        this.polynomial = new LinearVectorPolynomial(numFeatures);
    }

    public void train(DataSetType dataSet, Vector y, ISupervisedOptimizer optimizer){
        optimizer.optimize(dataSet, y, this.polynomial);
    }

    /**
     * Predict the value for the given input
     */
    public double predict(Vector y){
        return this.polynomial.evaluate(y);
    }

    /**
     * The object that represents the linear polynomial
     */
    LinearVectorPolynomial polynomial;
}
