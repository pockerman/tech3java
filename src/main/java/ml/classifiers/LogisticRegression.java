package ml.classifiers;

import algorithms.optimizers.ISupervisedOptimizer;
import datastructs.interfaces.I2DDataSet;
import datastructs.maths.Vector;
import maths.functions.IVectorRealFunction;

import java.util.List;

public class LogisticRegression<DataSetType extends I2DDataSet,
                                HypothesisType extends IVectorRealFunction<Vector>> extends ClassifierBase<DataSetType> {

    /**
     * Constructor.
     */
    public LogisticRegression(HypothesisType hypothesis, ISupervisedOptimizer optimizer){
        super();
        this.hypothesis = hypothesis;
        this.optimizer = optimizer;
    }

    /**
     * Train the model using the provided dataset
     */
    @Override
    public <OutputType> OutputType train(DataSetType dataSet, List<Integer> labels){
        return this.optimizer.optimize(dataSet, labels, this.hypothesis);
    }

    /**
     * Predict the class of the given data point
     */
    @Override
    public <PointType> Integer  predict(PointType point){
        return 0;
    }

    /**
     * The hypothesis function assumed by the regressor
     */
    protected HypothesisType hypothesis;
    protected ISupervisedOptimizer optimizer;
}
