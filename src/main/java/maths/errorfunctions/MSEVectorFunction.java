package maths.errorfunctions;

import datastructs.interfaces.I2DDataSet;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.functions.IRegularizerFunction;
import maths.functions.IVectorRealFunction;

/**
 * The Mean Square Error or MSE is defined as
 * MSE = 1/N Sum_{i = 1}^N (y_i - \hat{y}_i)^2
 *
 * The \hat{y} value is modeled after the IVectorRealFunction passed
 * to the object when instantiated
 */
public class MSEVectorFunction implements IVectorErrorRealFunction {

    /**
     * Constructor
     */
    public MSEVectorFunction(IVectorRealFunction<Vector> hypothesis ){

        this.hypothesis = hypothesis;
        this.regularizerFunction = null;
    }

    /**
     * Constructor
     */
    public MSEVectorFunction(IVectorRealFunction<Vector> hypothesis, IRegularizerFunction regularizerFunction ){

        this.hypothesis = hypothesis;
        this.regularizerFunction = regularizerFunction;
    }

    /**
     * Evaluate the error function using the given data, labels
     * @param data
     * @param labels
     * @return
     */
    @Override
    public <DataSetType extends I2DDataSet> double evaluate(DataSetType data, Vector labels){

        if(data.m() != labels.size()){
            throw new IllegalArgumentException("Invalid number of data points and labels vector size");
        }

        double result = 0.0;

        for(int rowIdx=0; rowIdx<data.m(); ++rowIdx){
            Vector row = (Vector) data.getRow(rowIdx);
            double diff = labels.get(rowIdx) - this.hypothesis.evaluate(row);
            diff *= diff;
            result += diff;
        }

        result /= data.m();

        if(regularizerFunction != null){
            result += regularizerFunction.evaluate(null);
        }

        return result;
    }

    /**
     * Returns the gradients on the given data
     */
    @Override
    public <DataSetType extends I2DDataSet> Vector gradients(DataSetType data, Vector labels){


        Vector gradients = new Vector(this.hypothesis.numCoeffs(), 0.0);

        for(int rowIdx=0; rowIdx<data.m(); ++rowIdx){

            Vector row = (Vector) data.getRow(rowIdx);

            double diff = (labels.get(rowIdx) - this.hypothesis.evaluate(row));

            Vector hypothesisGrads = this.hypothesis.coeffGradients(row);

            for(int coeff=0; coeff<this.hypothesis.numCoeffs(); ++coeff){
                gradients.add(coeff, (-2.0/data.m())*diff*hypothesisGrads.get(coeff));
            }
        }

        return gradients;
    }

    private IVectorRealFunction<Vector> hypothesis;
    IRegularizerFunction regularizerFunction;
}
