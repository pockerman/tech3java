package applications.ml;

import algorithms.optimizers.BatchGradientDescent;
import algorithms.optimizers.GDInput;
import algorithms.utils.DefaultIterativeAlgorithmController;
import algorithms.utils.IterativeAlgorithmResult;
import datastructs.maths.DenseMatrixSet;
import datastructs.maths.RowBuilder;
import datastructs.maths.Vector;
import datastructs.utils.RowType;
import maths.errorfunctions.MSEVectorFunction;
import maths.functions.LinearVectorPolynomial;
import ml.regression.LinearRegressor;
import tech.tablesaw.api.Table;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;

/** Category: Machine Learning
 * ID: Example2
 * Description: Using LinearRegressor class
 * Taken From:
 * Details:
 * Dataset taken from: https://archive.ics.uci.edu/ml/datasets/Energy+efficiency.
 * TODO
 */
public class Example2 {


    public static void main(String[] args)throws IOException{

        // load the data
        Table dataSet = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/car_plant.csv"));

        Vector labels = new Vector(dataSet, "Electricity Usage");
        Table reducedDataSet = dataSet.removeColumns("Electricity Usage").first(dataSet.rowCount());

        DenseMatrixSet<Double> denseMatrixSet = new DenseMatrixSet(RowType.Type.DOUBLE_VECTOR, new RowBuilder(), reducedDataSet.rowCount(), 2, 1.0);
        denseMatrixSet.setColumn(1, reducedDataSet.doubleColumn(0));

        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(1);
        LinearRegressor regressor = new LinearRegressor(hypothesis);

        GDInput gdInput = new GDInput();
        gdInput.showIterations = true;
        gdInput.eta=0.01;
        gdInput.errF = new MSEVectorFunction(hypothesis);
        gdInput.iterationContorller = new DefaultIterativeAlgorithmController(10000,1.0e-8);

        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);

        IterativeAlgorithmResult result = (IterativeAlgorithmResult) regressor.train(denseMatrixSet, labels, gdSolver);

        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+" slope: "+hypothesis.getCoeff(1));
    }
}
