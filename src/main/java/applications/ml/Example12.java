package applications.ml;

import datastructs.interfaces.IVector;
import datastructs.maths.DenseMatrixSet;
import maths.ConfusionMatrix;
import maths.functions.distances.EuclideanVectorCalculator;
import ml.classifiers.KNNClassifier;
import utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Category: Machine Learning
 * ID: Example11
 * Description: Using the ```ConfusionMatrix``` class
 * Taken From:
 * Taken From:
 * Details:
 * TODO
 */
public class Example12 {




    public static void main(String[] args) throws IOException, IllegalArgumentException{

        // load the data set
        Pair<DenseMatrixSet<Double>, List<Integer>> data = DataSetLoader.loadIrisDataSet();

        KNNClassifier<Double, DenseMatrixSet<Double>,
                EuclideanVectorCalculator<Double>,
                ClassificationVoter> classifier = new KNNClassifier<Double, DenseMatrixSet<Double>,
                EuclideanVectorCalculator<Double>, ClassificationVoter>(2, false);

        classifier.setDistanceCalculator(new EuclideanVectorCalculator<Double>());
        classifier.setMajorityVoter(new ClassificationVoter());


        classifier.train(data.first, data.second);

        List<Pair<Integer, Integer>> results = new ArrayList<>();

        for(int rowIdx=0; rowIdx<data.first.m(); ++rowIdx){

            IVector<Double> row = data.first.getRow(rowIdx);
            Integer classIdx = data.second.get(rowIdx);

            Integer predictedIdx = classifier.predict(row);
            results.add(PairBuilder.makePair(classIdx, predictedIdx ));
        }

        List<String> names = new ArrayList<>();

        names.add("Iris-setosa");
        names.add("Iris-versicolor");
        names.add("Iris-virginica");

        ConfusionMatrix confusionMatrix = new ConfusionMatrix(results, names);
        System.out.println(confusionMatrix.toString());

    }
}
