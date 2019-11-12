package maths.errorfunctions;

import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.IVectorErrorRealFunction;
import maths.IVectorRealFunction;

public class MSEVectorFunction implements IVectorErrorRealFunction {

    public MSEVectorFunction(IVectorRealFunction<Vector> hypothesis ){

        this.hypothesis = hypothesis;
    }

    /**
     * Evaluate the error function using the given data, labels
     * @param data
     * @param labels
     * @return
     */
    @Override
    public double evaluate(DenseMatrix data, Vector labels){

        if(data.m() != labels.size()){
            throw new IllegalArgumentException("Invalid number of data points and labels vector size");
        }

        double rlst = 0.0;

        for(int rowIdx=0; rowIdx<data.m(); ++rowIdx){
            Vector row = data.row(rowIdx);
            double diff = labels.get(rowIdx) - this.hypothesis.evaluate(row);
            diff *= diff;
            rlst += diff;
        }
        return rlst/data.m();
    }

    /**
     * Returns the gradients on the given data
     */
    @Override
    public Vector gradients(DenseMatrix data, Vector labels){


        Vector gradients = new Vector(this.hypothesis.numCoeffs(), 0.0);
        for(int rowIdx=0; rowIdx<data.m(); ++rowIdx){

            Vector row = data.row(rowIdx);

            double diff = (labels.get(rowIdx) - this.hypothesis.evaluate(row));

            Vector hypothesisGrads = this.hypothesis.gradidents(row);

            for(int coeff=0; coeff<this.hypothesis.numCoeffs(); ++coeff){
                gradients.add(coeff, (-2.0/data.m())*diff*hypothesisGrads.get(coeff));
            }
        }

        return gradients;
    }

    private IVectorRealFunction<Vector> hypothesis;
}
