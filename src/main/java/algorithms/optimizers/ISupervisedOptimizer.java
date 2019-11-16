package algorithms.optimizers;

import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.functions.IVectorRealFunction;

public interface ISupervisedOptimizer {

    <OutPutType> OutPutType optimize(final DenseMatrix data, final Vector y, IVectorRealFunction f);
}
