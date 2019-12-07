package ml.classifiers;

import datastructs.interfaces.I2DDataSet;

import java.util.List;

public abstract  class ClassifierBase<DataSetType extends I2DDataSet> {


    /**
     * Train the model using the provided dataset
     */
    public abstract  <OutputType> OutputType train(DataSetType dataSet, List<Integer> labels);

    /**
     * Predict the class of the given data point
     */
    public abstract <PointType> Integer  predict(PointType point);

    /**
     * Constructor
     */
    protected ClassifierBase()
    {}
}
