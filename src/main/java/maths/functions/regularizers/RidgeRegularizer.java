package maths.functions.regularizers;

import datastructs.maths.Vector;
import maths.functions.IRegularizerFunction;
import maths.functions.IVectorRealFunction;

public class RidgeRegularizer implements IRegularizerFunction {

    /**
     * Constructor.
     */
    public RidgeRegularizer(double lambda, int start_coeffs, IVectorRealFunction<Vector> hypothesis){

        this.start_coeffs = start_coeffs;
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

        for(int c=start_coeffs; c<coeffs.size(); ++c){

            double coeff = coeffs.get(c);
            sum += coeff*coeff;

        }

        return lambda*sum;
    }


    int start_coeffs;
    double lambda;
    IVectorRealFunction<Vector> hypothesis;
}
