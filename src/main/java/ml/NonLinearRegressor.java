package ml;

import datastructs.maths.DenseMatrix;
import maths.functions.IVectorRealFunction;
import maths.functions.NonLinearVectorPolynomial;
import maths.functions.ScalarMonomial;

public class NonLinearRegressor<DataSetType extends DenseMatrix, HypothesisType extends IVectorRealFunction > extends RegressorBase<DataSetType, HypothesisType > {

    /**
     * Constructor
     */
    /*public NonLinearRegressor(ScalarMonomial...terms){
        super(new NonLinearVectorPolynomial(terms));
    }*/

    /**
     * Constructor
     */
    public NonLinearRegressor(HypothesisType hypothesis){
        super(hypothesis);
    }

}
