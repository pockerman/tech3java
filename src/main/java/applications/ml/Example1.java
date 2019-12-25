package applications.ml;

import datastructs.maths.DenseMatrixSet;
import datastructs.maths.RowBuilder;
import datastructs.maths.Vector;
import datastructs.utils.RowType;
import maths.EuclideanVectorCalculator;
import ml.classifiers.KNNClassifier;
import utils.ClassificationVoter;

import java.util.ArrayList;
import java.util.List;

/** Category: Machine Learning
 * ID: Example1
 * Description: Classification with vanilla KNN algorithm
 * Taken From:
 * Details:
 * TODO
 */

public class Example1 {


    public static void main(String[] args){

        DenseMatrixSet<Double> dataSet = new DenseMatrixSet(RowType.Type.VECTOR, new RowBuilder());
        dataSet.create(12, 2);
        dataSet.set(0, 1.0, 3.0);
        dataSet.set(1, 1.5, 2.0);
        dataSet.set(2, 2.0, 1.0);
        dataSet.set(3, 2.5, 4.0 );
        dataSet.set(4, 3.0, 1.5);
        dataSet.set(5, 3.5, 2.5);
        dataSet.set(6, 5.0, 5.0);
        dataSet.set(7, 5.5, 4.0);
        dataSet.set(8, 6.0, 6.0);
        dataSet.set(9, 6.5, 4.5 );
        dataSet.set(10, 7.0, 1.5);
        dataSet.set(11, 8.0, 2.5);

        List<Integer> labels = new ArrayList<>(dataSet.m());

        for(int i=0; i<6; ++i) {
            labels.add(0);
        }

        for(int i = 6; i<dataSet.m(); ++i) {
            labels.add(1);
        }


        KNNClassifier<DenseMatrixSet,
                EuclideanVectorCalculator<Double>,
                ClassificationVoter> classifier = new KNNClassifier<DenseMatrixSet,
                EuclideanVectorCalculator<Double>, ClassificationVoter>(2, false);

        classifier.setDistanceCalculator(new EuclideanVectorCalculator<Double>());
        classifier.setMajorityVoter(new ClassificationVoter());


        classifier.train(dataSet, labels);

        Vector r = new Vector(3.1, 2.2);
        Integer classIdx =  classifier.predict(r);

        System.out.println("Point "+r+" has class index "+ classIdx);

        r = new Vector(9.1, 6.2);
        classIdx =  classifier.predict(r);

        System.out.println("Point "+r+" has class index "+ classIdx);

    }
}
