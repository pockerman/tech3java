package applications.ml;


import algorithms.AlgorithmResult;
import algorithms.optimizers.BatchGradientDescent;
import algorithms.optimizers.GDInput;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.LinearVectorPolynomial;
import maths.errorfunctions.MSEVectorFunction;
import tech.tablesaw.api.Table;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;

/** Category: Machine Learning
 * ID: Example5
 * Description: Using Batch Gradient Descent
 * Taken From:
 * Details:
 * TODO
 */

public class Example5 {


    public static void main(String[] args)throws IOException {

        // load the data
        Table dataSet = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/ENB2012_data.csv"));

        DenseMatrix denseMatrix = new DenseMatrix();
        denseMatrix.initializeFrom(dataSet);

        Vector labels = new Vector();
        //labels.initializeFrom(dataSet);

        GDInput gdInput = new GDInput();

        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);
        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(2);
        MSEVectorFunction objective = new MSEVectorFunction(hypothesis);

        AlgorithmResult result = gdSolver.optimize(denseMatrix, labels, objective, hypothesis);


    }
}
