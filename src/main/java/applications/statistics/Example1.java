package applications.statistics;


import algorithms.optimizers.BatchGradientDescent;
import algorithms.optimizers.GDInput;
import algorithms.utils.DefaultIterativeAlgorithmController;
import algorithms.utils.IterativeAlgorithmResult;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.errorfunctions.MSEVectorFunction;
import maths.errorfunctions.SSEVectorFunction;
import maths.functions.LinearVectorPolynomial;
import ml.LinearRegressor;
import tech.tablesaw.api.Table;
import utils.ListUtils;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;

/** Category: Statistics
 * ID: Example1
 * Description: Goodness of fit of regression line
 * Taken From:
 * Details:
 * TODO
 */
public class Example1 {

    public static void main(String[] args)throws IOException {

        // load the data
        Table dataSet = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/car_plant.csv"));

        Vector labels = new Vector(dataSet, "Electricity Usage");
        Table reducedDataSet = dataSet.removeColumns("Electricity Usage").first(dataSet.rowCount());

        DenseMatrix denseMatrix = new DenseMatrix(reducedDataSet.rowCount(), 2, 1.0);
        denseMatrix.setColumn(1, reducedDataSet.doubleColumn(0));

        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(1);
        LinearRegressor regressor = new LinearRegressor(hypothesis);

        GDInput gdInput = new GDInput();
        gdInput.showIterations = false;
        gdInput.eta=0.01;
        gdInput.errF = new MSEVectorFunction(hypothesis);
        gdInput.iterationContorller = new DefaultIterativeAlgorithmController(10000,1.0e-8);

        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);

        IterativeAlgorithmResult result = (IterativeAlgorithmResult) regressor.train(denseMatrix, labels, gdSolver);

        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+" slope: "+hypothesis.getCoeff(1));

        // let's see the max error over the dateset
        Vector errors = regressor.getErrors(denseMatrix, labels);
        double maxError = ListUtils.max(errors.getRawData());

        System.out.println("Maximum error over dataset: "+maxError);

        // let's get an estimate of the error variance.
        //The error variance sigma^2 can be estimated by considering the deviations between the observed
        //data values y_i and their fitted values \hat(y)_i . Specifically, the sum of squares for error SSE is defined
        //to be the sum of the squares of these deviations
        Vector yhat = regressor.predict(denseMatrix);

        double sseError = SSEVectorFunction.error(labels, yhat);

        System.out.println("Estimate of error variance: "+sseError/ (yhat.size()-2));

        // interval estimation
        double Sxx = ListUtils.sxx(denseMatrix.getColumn(1).getRawData());

        System.out.println("Estimate of Sxx: "+Sxx);

    }
}
