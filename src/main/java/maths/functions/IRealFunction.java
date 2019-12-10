package maths.functions;

import datastructs.maths.Vector;

public interface IRealFunction<InputType> extends IFunction<InputType, Double> {

    /**
     * Returns the number of coefficients
     */
    int numCoeffs();

    /**
     * Returns the coefficients of the vector function
     */
    Vector getCoeffs();

    /**
     * Returns the i-th coefficient
     */
    double getCoeff(int i);

    /**
     * Set the coefficients of the function
     */
    void setCoeffs(double[] coeffs);

    /**
     * Set the coefficents of the function
     */
    default void setCoeffs(Vector coeffs){this.setCoeffs(coeffs.toArrary());}

}
