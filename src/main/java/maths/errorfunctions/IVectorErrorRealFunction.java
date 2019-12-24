package maths.errorfunctions;

import datastructs.interfaces.I2DDataSet;
import datastructs.maths.Vector;

public interface IVectorErrorRealFunction {


    /**
     * Evaluate the error function using the given data, labels
     * @param data
     * @param labels
     * @return
     */
    <DataSetType extends I2DDataSet> double evaluate(DataSetType data, Vector labels);

    /**
     * Returns the gradients on the given data
     */
    <DataSetType extends I2DDataSet> Vector gradients(DataSetType data, Vector labels);


}
