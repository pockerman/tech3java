package maths;

import datastructs.maths.Vector;
import datastructs.maths.VectorOperations;

/**
 * class that represents a linear polynomial
 */
public class LinearVectorPolynomial implements IVectorRealFunction<Vector> {

    /**
      * Construct a vector polynomial: f = w0 + w1*X1 + w2*X2+...worder-1*Xorder-1
     */
    public LinearVectorPolynomial(int order){

        this.coeffs = new Vector(order, 0.0);
    }

    @Override
    public Double evaluate(Vector input){
        return VectorOperations.dotProduct(this.coeffs, input);
    }

    /**
     * Set the coefficients of the Polynomial
     */
    public final void setCoeffs(Vector coeffs){
        this.coeffs = coeffs;
    }

    /**
     * Returns the coefficients of the vector function
     */
    @Override
    public final Vector getCoeffs(){
        return this.coeffs;
    }

    /**
     * Returns the number of coefficients
     */
    @Override
    public final int numCoeffs(){
        return this.coeffs.size();
    }

    /**
     * Zero the coefficients
     */
    public final void zeroCoeffs(){
        coeffs.zero();
    }


    /**
     * The coefficients of the vector
     */
    private Vector coeffs;

}
