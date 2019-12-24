package ml.regression;

import datastructs.maths.DenseMatrixSet;
import maths.functions.NonLinearVectorPolynomial;
import maths.functions.ScalarMonomial;

public class NonLinearRegressor<DataSetType extends DenseMatrixSet> extends RegressorBase<DataSetType, NonLinearVectorPolynomial > {

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
