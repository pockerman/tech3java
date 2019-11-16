package ml;

import algorithms.optimizers.ISupervisedOptimizer;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.functions.IVectorRealFunction;

public class RegressorBase<DataSetType extends DenseMatrix, HypothesisType extends IVectorRealFunction> {

    /**
     * Protected constructor.
     */
    protected RegressorBase(HypothesisType hypothesis){
        this.hypothesisType = hypothesis;
    }

    /**
     * Train the regressor on the given dataset
     */
    public <OutputType> OutputType train(DataSetType dataSet, Vector y, ISupervisedOptimizer optimizer){
        return optimizer.optimize(dataSet, y, this.hypothesisType);
    }

    /**
     * Predict the value for the given input
     */
    public double predict(Vector y){
        return (double) this.hypothesisType.evaluate(y);
    }


    /**
     * The hypothesis function assumed by the regressor
     */
    protected HypothesisType hypothesisType;
}
