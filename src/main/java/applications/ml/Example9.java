package applications.ml;


import algorithms.optimizers.BatchGradientDescent;
import algorithms.optimizers.GDInput;
import algorithms.utils.DefaultIterativeAlgorithmController;
import algorithms.utils.IterativeAlgorithmResult;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.EuclideanVectorCalculator;
import maths.errorfunctions.LogisticMSEVectorFunction;
import maths.errorfunctions.MSEVectorFunction;
import maths.functions.LinearVectorPolynomial;
import maths.functions.SigmoidFunction;
import ml.classifiers.LogisticRegressionClassifier;
import ml.classifiers.ThreadedKNNClassifier;
import parallel.partitioners.MatrixRowPartitionPolicy;
import parallel.partitioners.RangePartitioner;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import utils.ClassificationVoter;
import utils.Pair;
import utils.PairBuilder;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/** Category: Machine Learning
 * ID: Example
 * Description: Classification with vanilla LogisticRegression
 * Taken From:
 * Details:
 * TODO
 */
public class Example9 {

    public static Pair<DenseMatrix, Vector> createDataSet() throws IOException, IllegalArgumentException {

        // load the data
        Table dataSetTable = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/iris_dataset_reduced.csv"));

        Column species  = dataSetTable.column("species");

        Vector labels = new Vector(species.size());

        for (int i = 0; i < species.size(); i++) {

            String label = (String) species.get(i);

            if(label.equals("Iris-setosa")){

                labels.set(i, 0.0);
            }
            else if(label.equals("Iris-versicolor")){

                labels.set(i, 1);
            }
            else{
                throw new IllegalArgumentException("Unknown class");
            }
        }

        Table reducedDataSet = dataSetTable.removeColumns("species").first(dataSetTable.rowCount());
        DenseMatrix dataSet = new DenseMatrix(reducedDataSet.rowCount(), reducedDataSet.columnCount() + 1, 1.0);
        dataSet.setColumn(1, reducedDataSet.doubleColumn(0));
        dataSet.setColumn(2, reducedDataSet.doubleColumn(1));
        dataSet.setColumn(3, reducedDataSet.doubleColumn(2));
        dataSet.setColumn(4, reducedDataSet.doubleColumn(3));
        return PairBuilder.makePair(dataSet, labels);
    }

    public static void main(String[] args) throws IOException, IllegalArgumentException{

        Pair<DenseMatrix, Vector> data = Example9.createDataSet();

        System.out.println("Number of rows: "+data.first.m());
        System.out.println("Number of labels: "+data.second.size());

        SigmoidFunction hypothesis = new SigmoidFunction(new LinearVectorPolynomial(4));

        GDInput gdInput = new GDInput();
        gdInput.showIterations = true;
        gdInput.eta = 0.01;
        gdInput.errF = new LogisticMSEVectorFunction(hypothesis);
        gdInput.iterationContorller = new DefaultIterativeAlgorithmController(100000,1.0e-8);

        // the optimizer
        BatchGradientDescent gdSolver = new BatchGradientDescent(gdInput);

        // the classifier
        LogisticRegressionClassifier<DenseMatrix, LinearVectorPolynomial> classifier = new LogisticRegressionClassifier(hypothesis, gdSolver );

        // train the model
        IterativeAlgorithmResult result = classifier.train(data.first, data.second);

        System.out.println(" ");
        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+" slope1: "+hypothesis.getCoeff(1)+" slope2: "+hypothesis.getCoeff(2));

        Vector point = new Vector(1.0, 5.7,2.8,4.1,1.3);
        Integer classIdx = classifier.predict(point);

        System.out.println("Point "+ point +" has class index "+ classIdx);
    }

}
