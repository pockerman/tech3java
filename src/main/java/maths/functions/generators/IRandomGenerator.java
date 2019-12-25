package maths.functions.generators;

import datastructs.interfaces.I2DDataSet;
import datastructs.interfaces.IVector;

import java.util.List;

/**
 * General interface to model
 */
public interface IRandomGenerator<PointType> {

    <DataSetTp extends I2DDataSet<IVector<PointType>>>  List<IVector<PointType>> generate(DataSetTp dataSet, int n);
}
