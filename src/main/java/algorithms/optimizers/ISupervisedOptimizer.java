package algorithms.optimizers;

import datastructs.interfaces.I2DDataSet;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.functions.IVectorRealFunction;

import java.util.List;

public interface ISupervisedOptimizer {

    /**
     * Optimize approximate function f on the given dataset and the
     * given labels. Derived classes specify the output
     */
    //<OutPutType> OutPutType optimize(final DenseMatrix data, final Vector y, IVectorRealFunction f);

    /**
     * Optimize approximate function f on the given dataset and the
     * given labels. Derived classes specify the output
     */
    <OutPutType, DataSetType extends I2DDataSet> OutPutType optimize(final DataSetType data, final Vector y, IVectorRealFunction f);
}
