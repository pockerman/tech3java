package maths.functions.generators;

import datastructs.interfaces.I2DDataSet;

import java.util.List;

/**
 * General interface to model
 */
public interface IRandomGenerator<PointType> {

    <DataSetTp extends I2DDataSet<PointType>> List<PointType> generate(DataSetTp dataSet, int n);
}
