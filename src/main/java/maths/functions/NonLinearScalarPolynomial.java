package maths.functions;

import datastructs.maths.Vector;

import java.util.ArrayList;
import java.util.List;

public class NonLinearScalarPolynomial implements IVectorRealFunction<Vector> {

    /**
     * Constructor
     */
    public NonLinearScalarPolynomial(ScalarMonomial...terms){
        this.terms = new ArrayList<>();

        for (ScalarMonomial monomial: terms) {
            this.terms.add(monomial);
        }
    }

    /**
     * Evaluate the scalar function pretending that it is vector
     */
    @Override
    public Double evaluate( Vector input){

        if(input.size() != 2){
            throw new IllegalArgumentException("Invalid number of coeffs. "+input.size()+" should be 2");
        }

        double rslt = 0.0;
        for (int i = 0; i < this.terms.size(); i++) {

            if( i == 0) {
                rslt += this.terms.get(i).evaluate(input.get(0));
            }
            else {
                rslt += this.terms.get(i).evaluate(input.get(1));
            }
        }
        return rslt;
    }


    /**
     * Set the coefficients of the Polynomial
     */
    public final void setCoeffs(Vector coeffs){

        this.setCoeffs(coeffs.toArrary());
    }

    /**
     * Set the coefficients of the function
     */
    @Override
    public final void setCoeffs(double[] coeffs){

        if(coeffs.length != this.terms.size()){
            throw new IllegalArgumentException("Invalid number of coeffs. "+coeffs.length+" should be "+this.terms.size());
        }

        for (int i = 0; i < this.terms.size() ; i++) {
            this.terms.get(i).setCoeff(coeffs[i]);
        }
    }

    /**
     * Returns the coefficients of the vector function
     */
    @Override
    public final Vector getCoeffs(){

        Vector rslt = new Vector(this.terms.size(), 0.0);

        for (int i = 0; i < rslt.size() ; i++) {

            rslt.set(i, this.terms.get(i).getCoeffs().get(0));
        }

        return rslt;
    }

    /**
     * Returns the number of coefficients
     */
    @Override
    public final int numCoeffs(){
        return this.terms.size();
    }

    /**
     * Returns the gradients with respect to the coefficients at the given data point
     */
    @Override
    public Vector gradidents(Vector data){

        if(data.size() != 2){
            throw new IllegalArgumentException("Invalid number of coeffs. "+data.size()+" should be 2");
        }

        Vector rslt = new Vector(this.terms.size(), 0.0);

        for (int i = 0; i < rslt.size() ; i++) {

            if( i == 0){
                rslt.set(i, this.terms.get(i).gradient(data.get(0)));
            }
            else{
                rslt.set(i, this.terms.get(i).gradient(data.get(1)));
            }
        }

        return rslt;
    }

    /**
     * Returns the gradient with respect to the i-th coeff
     */
    @Override
    public double gradient(int i, Vector data){

        if(data.size() != 2){
            throw new IllegalArgumentException("Invalid number of coeffs. "+data.size()+" should be 2");
        }

        if(i == 0){
            return this.terms.get(i).gradient(data.get(0));
        }

        return this.terms.get(i).gradient(data.get(1));
    }


    /**
     * Returns the coeff-th coefficient
     */
    public double getCoeff(int coeff){
        return this.terms.get(coeff).getCoeffs().get(0);
    }



    List<ScalarMonomial> terms;

}
