package applications.ml;


import algorithms.optimizers.BatchGradientDescent;
import algorithms.optimizers.GDInput;
import algorithms.utils.DefaultIterativeAlgorithmController;
import algorithms.utils.IterativeAlgorithmResult;
import datastructs.maths.DenseMatrixSet;
import datastructs.maths.RowBuilder;
import datastructs.maths.Vector;
import datastructs.utils.RowType;
import maths.errorfunctions.LogisticMSEVectorFunction;
import maths.functions.LinearVectorPolynomial;
import maths.functions.SigmoidFunction;
import ml.classifiers.LogisticRegressionClassifier;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import utils.Pair;
import utils.PairBuilder;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;


/** Category: Machine Learning
 * ID: Example9
 * Description: Classification with vanilla LogisticRegression
 * Taken From:
 * Details:
 * TODO
 */
public class Example9 {

    public static Pair<DenseMatrixSet, Vector> createDataSet() throws IOException, IllegalArgumentException {

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
        DenseMatrixSet dataSet = new DenseMatrixSet(RowType.Type.DOUBLE_VECTOR, new RowBuilder(), reducedDataSet.rowCount(), reducedDataSet.columnCount() + 1, 1.0);
        dataSet.setColumn(1, reducedDataSet.doubleColumn(0));
        dataSet.setColumn(2, reducedDataSet.doubleColumn(1));
        dataSet.setColumn(3, reducedDataSet.doubleColumn(2));
        dataSet.setColumn(4, reducedDataSet.doubleColumn(3));
        return PairBuilder.makePair(dataSet, labels);
    }

    public static void main(String[] args) throws IOException, IllegalArgumentException{

        Pair<DenseMatrixSet, Vector> data = Example9.createDataSet();

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
        LogisticRegressionClassifier<DenseMatrixSet<Double>, LinearVectorPolynomial> classifier = new LogisticRegressionClassifier(hypothesis, gdSolver );

        // train the model
        IterativeAlgorithmResult result = (IterativeAlgorithmResult) classifier.train(data.first, data.second);

        System.out.println(" ");
        System.out.println(result);
        System.out.println("Intercept: "+hypothesis.getCoeff(0)+
                           " slope1: "+hypothesis.getCoeff(1) +
                           " slope2: "+hypothesis.getCoeff(2) +
                           " slope3: "+hypothesis.getCoeff(3));

        // use 1.0 to account for the intercept term
        Vector point = new Vector(1.0, 5.7,2.8,4.1,1.3);
        Integer classIdx = classifier.predict(point);

        System.out.println("Point "+ point +" has class index "+ classIdx);
    }

}
