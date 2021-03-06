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

import maths.functions.regularizers.LassoRegularizer;
import maths.functions.regularizers.RidgeRegularizer;

import ml.regression.LinearRegressor;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

import utils.Pair;
import utils.PairBuilder;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;

/** Category: Machine Learning
 * ID: Example9
 * Description: Linear regression with Lasso
 * Taken From:
 * Details:
 * TODO
 */
public class Example10 {

    public static Pair<DenseMatrixSet, Vector> createDataSet() throws IOException, IllegalArgumentException {

        // load the data
        Table dataSetTable = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/X_Y_Sinusoid_Data.csv"));

        DoubleColumn y  = dataSetTable.doubleColumn("y");

        Vector labels = new Vector(y);

        Table reducedDataSet = dataSetTable.removeColumns("y").first(dataSetTable.rowCount());
        DenseMatrixSet dataSet = new DenseMatrixSet(RowType.Type.DOUBLE_VECTOR, new RowBuilder(), reducedDataSet.rowCount(), reducedDataSet.columnCount() + 1, 1.0);
        dataSet.setColumn(1, reducedDataSet.doubleColumn(0));
        return PairBuilder.makePair(dataSet, labels);
    }

    public static void linearRegression(DenseMatrixSet data, Vector labels){

        System.out.println("Doing LinearRegression");

        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(1);

        GDInput gdInput = new GDInput();
        gdInput.showIterations = false;
        gdInput.eta = 0.01;
        gdInput.errF = new MSEVectorFunction(hypothesis);
        gdInput.iterationContorller = new DefaultIterativeAlgorithmController(100000,1.0e-8);

        // the optimizer
        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);

        // the classifier
        LinearRegressor<DenseMatrixSet<Double>> regressor = new LinearRegressor(hypothesis);

        // train the model
        IterativeAlgorithmResult result = (IterativeAlgorithmResult) regressor.train(data, labels, gdSolver);

        System.out.println(" ");
        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+
                " slope1: "+hypothesis.getCoeff(1));

    }

    public static void ridgeRegression(DenseMatrixSet data, Vector labels){

        System.out.println("Doing Ridge LinearRegression");
        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(1);
        RidgeRegularizer ridgeRegularizer = new RidgeRegularizer(0.001, 1, hypothesis);

        GDInput gdInput = new GDInput();
        gdInput.showIterations = false;
        gdInput.eta = 0.01;
        gdInput.errF = new MSEVectorFunction(hypothesis, ridgeRegularizer);
        gdInput.iterationContorller = new DefaultIterativeAlgorithmController(100000,1.0e-8);

        // the optimizer
        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);

        // the classifier
        LinearRegressor<DenseMatrixSet<Double>> regressor = new LinearRegressor(hypothesis);

        // train the model
        IterativeAlgorithmResult result = (IterativeAlgorithmResult) regressor.train(data, labels, gdSolver);

        System.out.println(" ");
        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+
                " slope1: "+hypothesis.getCoeff(1));

    }

    public static void lassoRegression(DenseMatrixSet data, Vector labels){

        System.out.println("Doing Lasso LinearRegression");
        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(1);
        LassoRegularizer lassoRegularizer = new LassoRegularizer(0.0001, 1, hypothesis);

        GDInput gdInput = new GDInput();
        gdInput.showIterations = false;
        gdInput.eta = 0.01;
        gdInput.errF = new MSEVectorFunction(hypothesis, lassoRegularizer);
        gdInput.iterationContorller = new DefaultIterativeAlgorithmController(100000,1.0e-8);

        // the optimizer
        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);

        // the classifier
        LinearRegressor<DenseMatrixSet<Double>> regressor = new LinearRegressor(hypothesis);

        // train the model
        IterativeAlgorithmResult result = (IterativeAlgorithmResult) regressor.train(data, labels, gdSolver);

        System.out.println(" ");
        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+
                " slope1: "+hypothesis.getCoeff(1));

    }


    public static void main(String[] args) throws IOException, IllegalArgumentException{

        Pair<DenseMatrixSet, Vector> data = Example10.createDataSet();

        System.out.println("Number of rows: "+data.first.m());
        System.out.println("Number of labels: "+data.second.size());

        Example10.linearRegression(data.first, data.second);
        Example10.ridgeRegression(data.first, data.second);
        Example10.lassoRegression(data.first, data.second);


    }
}
