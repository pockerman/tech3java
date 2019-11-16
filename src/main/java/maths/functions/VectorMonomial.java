package maths.functions;

import datastructs.maths.Vector;

/**
 * Class that models a function of the form f = a*X^order
 * where  X is vector valued
 */
public class VectorMonomial implements IVectorRealFunction<Vector> {

    /**
     * Constructor
     */
    public VectorMonomial(int order, double a){
        this.a = a;
        this.order = order;
    }

    /**
     * Evaluate the monomila at the given input
     */
    @Override
    public Double evaluate(Vector input){

        double rslt = 0.0;

        for (int i = 0; i < input.size(); i++) {
            rslt += this.a*Math.pow(input.get(i), this.order);
        }

        return rslt;
    }

    /**
     * Returns the number of coefficients
     */
    @Override
    public int numCoeffs(){ return 1;}

    /**
     * Returns the coefficients of the vector function
     */
    @Override
    public Vector getCoeffs(){return new Vector(1, this.a);}

    /**
     * Returns the gradients with respect to the coefficients at the given data point
     */
    @Override
    public Vector gradidents(Vector data){

        Vector grads = new Vector(data.size(), 0.0);

        for(int i=0; i<grads.size(); ++i){
            grads.set(i, this.a*this.order*Math.pow(data.get(i), this.order-1));
        }

        return grads;
    }

    /**
     * Returns the gradient with respect to the i-th coeff
     */
    @Override
    public double gradient(int i, Vector data){
        return this.a*this.order*Math.pow(data.get(i), this.order-1);
    }

    /**
     * Set the coefficients of the function
     */
    @Override
    public void setCoeffs(double[] coeffs){

        if(coeffs.length != 1){
            throw new IllegalArgumentException("Invalid number of coeffs. "+coeffs.length+" should be 1");
        }

        this.a = coeffs[0];
    }

    private double a;
    private int order;
}
