package ml;

import datastructs.maths.DenseMatrix;
import maths.functions.NonLinearVectorPolynomial;
import maths.functions.ScalarMonomial;

public class NonLinearRegressor<DataSetType extends DenseMatrix > extends RegressorBase<DataSetType, NonLinearVectorPolynomial > {

    /**
     * Constructor
     */
    public NonLinearRegressor(ScalarMonomial...terms){
        super(new NonLinearVectorPolynomial(terms));
    }

    /**
     * Constructor
     */
    public NonLinearRegressor(NonLinearVectorPolynomial hypothesis){
        super(hypothesis);
    }

}
