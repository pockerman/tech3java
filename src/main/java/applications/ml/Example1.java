package applications.ml;

import datastructs.MatrixDataSet;
import maths.EuclideanRowSetCalculator;
import ml.KNNClassifier;
import utils.ClassificationVoter;

/** Category: Machine Learning
 * ID: Example1
 * Description: Classification with vanilla KNN algorithm
 * Taken From:
 * Details:
 * TODO
 */

public class Example1 {


    public static void main(String[] args){

        MatrixDataSet<Double> dataSet = new MatrixDataSet<>("KNNDataSet");

        KNNClassifier<MatrixDataSet<Double>,
                EuclideanRowSetCalculator<Double>,
                ClassificationVoter> classifier = new KNNClassifier<MatrixDataSet<Double>,
                EuclideanRowSetCalculator<Double>, ClassificationVoter>(4, false);

        classifier.train(dataSet);
    }
}
