package algorithms.optimizers;

import algorithms.utils.IterativeAlgorithmResult;
import datastructs.interfaces.I2DDataSet;
import datastructs.maths.Vector;
import maths.functions.IVectorRealFunction;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

/**
 * Ordinary Least Squares optimizer for a real vector function
 */
public class OLSOptimizer implements ISupervisedOptimizer {

    /**
     * Optimize f on the given data
     */
    public <OutPutType, DataSetType extends I2DDataSet> OutPutType optimize(final DataSetType data, final Vector y, IVectorRealFunction f){

        IterativeAlgorithmResult reslt = new IterativeAlgorithmResult();
        reslt.numThreadsUsed = 1;

        // the object that will do the fitting for us
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();

        double[][] x = data.getSubMatrix(2, 1, 2);
        regression.newSampleData(y.toArrary(), x);
        double[] coeffs = regression.estimateRegressionParameters();
        f.setCoeffs(coeffs);
        return (OutPutType) reslt;
    }

    /**
     * Optimize approximate function f on the given dataset and the
     * given labels. Derived classes specify the output
     */
    /*public <OutPutType, DataSetType extends I2DDataSet> OutPutType optimize(final DataSetType data, final List<Integer> y, IVectorRealFunction f){
        throw new NotImplementedException("This function has not been implemented");
    }*/
}
