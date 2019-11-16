package applications.ml;

import algorithms.utils.DefaultIterativeAlgorithmController;
import algorithms.utils.IterativeAlgorithmResult;
import algorithms.optimizers.BatchGradientDescent;
import algorithms.optimizers.GDInput;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.LinearVectorPolynomial;
import maths.errorfunctions.MSEVectorFunction;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import utils.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/** Category: Machine Learning
 * ID: Example5
 * Description: Batch Gradient Descent with two features
 * Taken From:
 * Details:
 * TODO
 */

public class Example6 {

    public static Pair<DenseMatrix, Vector> loadNormalizedDataSet(File file)throws IOException{

        // load the data
        Table dataSet = TableDataSetLoader.loadDataSet(file);

        DoubleColumn y = dataSet.doubleColumn("Electricity Usage");
        ListUtils.normalize(y);
        Vector labels = new Vector(y);

        Table reducedDataSet = dataSet.removeColumns("Electricity Usage").first(dataSet.rowCount());
        ListUtils.normalize(reducedDataSet.doubleColumn(0));
        List<Double> coolingCol = ParseUtils.parseAsDouble(reducedDataSet.column(1));
        ListUtils.normalize(coolingCol);

        DenseMatrix denseMatrix = new DenseMatrix(reducedDataSet.rowCount(), 3, 1.0);
        denseMatrix.setColumn(1, reducedDataSet.doubleColumn(0));
        denseMatrix.setColumn(2, coolingCol);

        return PairBuilder.makePair(denseMatrix, labels);

    }

    public static void apacheOLS(DenseMatrix denseMatrix, Vector labels)throws IOException{

        // the object that will do the fitting for us
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();

        double[][] x = denseMatrix.getSubMatrix(2, 1, 2);
        regression.newSampleData(labels.toArrary(), x);
        double[] coeffs = regression.estimateRegressionParameters();
        System.out.println("Apache OLS: ");
        System.out.println("Intercept: "+coeffs[0]+" slope1: "+coeffs[1]+" slope2: "+coeffs[2]);

    }

    public static void main(String[] args)throws IOException {

        Pair<DenseMatrix, Vector> dataSet = Example6.loadNormalizedDataSet(new File("src/main/resources/datasets/car_plant_multi.csv"));

        System.out.println(" ");
        // compute with Apache OLS for reference
        Example6.apacheOLS(dataSet.first, dataSet.second);

        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(2);
        GDInput gdInput = new GDInput();
        gdInput.showIterations = false;
        //gdInput.numIterations = 10000;
        gdInput.eta=0.01;
        //gdInput.tolerance=1.0e-8;
        gdInput.errF = new MSEVectorFunction(hypothesis);
        gdInput.iterationContorller = new DefaultIterativeAlgorithmController(10000,1.0e-8);

        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);

        IterativeAlgorithmResult result = gdSolver.optimize(dataSet.first, dataSet.second, hypothesis);

        System.out.println(" ");
        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+" slope1: "+hypothesis.getCoeff(1)+" slope2: "+hypothesis.getCoeff(2));

    }
}
