package maths.functions.regularizers;

import datastructs.maths.Vector;
import maths.functions.IRegularizerFunction;
import maths.functions.IVectorRealFunction;

public class LassoRegularizer implements IRegularizerFunction {

    /**
     * Constructor.
     */
    public LassoRegularizer(double lambda, int startCoeffs, IVectorRealFunction<Vector > hypothesis){

        this.startCoeffs = startCoeffs;
        this.lambda = lambda;
        this.hypothesis = hypothesis;
    }

    /**
     * Returns the value of the regularizer
     */
    @Override
    public Double evaluate(Void input){

        Vector coeffs = hypothesis.getCoeffs();

        if(coeffs == null){
            throw new IllegalStateException("Hypothesis coefficients are null");
        }

        double sum = 0.0;

        for(int c=startCoeffs; c<coeffs.size(); ++c){

            double coeff = coeffs.get(c);
            sum += Math.abs(coeff);
        }

        return lambda*sum;
    }


    int startCoeffs;
    double lambda;
    maths.functions.IVectorRealFunction<Vector> hypothesis;
}
