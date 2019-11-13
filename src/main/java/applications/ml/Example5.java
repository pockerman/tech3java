package applications.ml;


import algorithms.AlgorithmResult;
import algorithms.optimizers.BatchGradientDescent;
import algorithms.optimizers.GDInput;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.LinearVectorPolynomial;
import maths.errorfunctions.MSEVectorFunction;
import tech.tablesaw.api.Table;
import tech.tablesaw.table.Relation;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;

/** Category: Machine Learning
 * ID: Example5
 * Description: Using Batch Gradient Descent with only one feature
 * Taken From:
 * Details:
 * TODO
 */

public class Example5 {


    public static void main(String[] args)throws IOException {

        // load the data
        Table dataSet = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/car_plant.csv"));

        Vector labels = new Vector(dataSet, "Electricity Usage");
        Table reducedDataSet = dataSet.removeColumns("Electricity Usage").first(dataSet.rowCount());

        DenseMatrix denseMatrix = new DenseMatrix(reducedDataSet.rowCount(), 2, 1.0);
        denseMatrix.setColumn(1, reducedDataSet.doubleColumn(0));

        GDInput gdInput = new GDInput();
        gdInput.showIterations = true;
        gdInput.numIterations = 10000;
        gdInput.eta=0.01;
        gdInput.tolerance=1.0e-8;

        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);
        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(1);
        MSEVectorFunction objective = new MSEVectorFunction(hypothesis);

        AlgorithmResult result = gdSolver.optimize(denseMatrix, labels, objective, hypothesis);

        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+" slope: "+hypothesis.getCoeff(1));


    }
}
