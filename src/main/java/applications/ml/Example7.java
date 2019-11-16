package applications.ml;

import algorithms.optimizers.BatchGradientDescent;
import algorithms.optimizers.GDInput;
import algorithms.utils.DefaultIterativeAlgorithmController;
import algorithms.utils.IterativeAlgorithmResult;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.errorfunctions.MSEVectorFunction;
import maths.functions.NonLinearScalarPolynomial;
import maths.functions.NonLinearVectorPolynomial;
import maths.functions.ScalarMonomial;
import ml.NonLinearRegressor;
import tech.tablesaw.api.Table;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;

/** Category: Machine Learning
 * ID: Example7
 * Description: Non linear Regression
 * Taken From:
 * Details:
 * TODO
 */
public class Example7 {

    public static void main(String[] args)throws IOException {

        // load the data
        Table dataSet = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/car_plant.csv"));

        Vector labels = new Vector(dataSet, "Electricity Usage");
        Table reducedDataSet = dataSet.removeColumns("Electricity Usage").first(dataSet.rowCount());

        DenseMatrix denseMatrix = new DenseMatrix(reducedDataSet.rowCount(), 2, 1.0);
        denseMatrix.setColumn(1, reducedDataSet.doubleColumn(0));

        // assume a hypothesis of the form w0 +w1*X + w2*X^2
        // initially all weights are set o zeor
        NonLinearScalarPolynomial hypothesis = new NonLinearScalarPolynomial(new ScalarMonomial(0, 0.0),
                                                                             new ScalarMonomial(1, 0.0),
                                                                             new ScalarMonomial(2, 0.0));

        // the regressor
        NonLinearRegressor regressor = new NonLinearRegressor(hypothesis);


        GDInput gdInput = new GDInput();
        gdInput.showIterations = true;
        gdInput.eta=0.01;
        gdInput.errF = new MSEVectorFunction(hypothesis);
        gdInput.iterationContorller = new DefaultIterativeAlgorithmController(10000,1.0e-8);

        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);

        IterativeAlgorithmResult result = (IterativeAlgorithmResult) regressor.train(denseMatrix, labels, gdSolver);

        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+" slope: "+hypothesis.getCoeff(1));

    }
}
