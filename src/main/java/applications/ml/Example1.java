package applications.ml;

import datastructs.MatrixDataSet;
import datastructs.RowDataSet;
import maths.EuclideanRowSetCalculator;
import ml.KNNClassifier;
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

        MatrixDataSet<Double> dataSet = new MatrixDataSet<>("KNNDataSet");
        dataSet.addColumns("X", "Y");

        KNNClassifier<MatrixDataSet<Double>,
                EuclideanRowSetCalculator<Double>,
                ClassificationVoter> classifier = new KNNClassifier<MatrixDataSet<Double>,
                EuclideanRowSetCalculator<Double>, ClassificationVoter>(2, false);

        classifier.setDistanceCalculator(new EuclideanRowSetCalculator<Double>());
        classifier.setMajorityVoter(new ClassificationVoter());


        RowDataSet<Double> r = new RowDataSet<>();
        r.add(1.0, 3.0);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(1.5, 2.0);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(2.0, 1.0);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(2.5, 4.0 );
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(3.0, 1.5);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(3.5, 2.5);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(5.0, 5.0);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(5.5, 4.0);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(6.0, 6.0);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(6.5, 4.5 );
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(7.0, 1.5);
        dataSet.addRow(r);

        r = new RowDataSet<>();
        r.add(8.0, 2.5);
        dataSet.addRow(r);

        List<Integer> labels = new ArrayList<>(dataSet.nRows());

        for(int i=0; i<6; ++i) {
            labels.add(0);
        }

        for(int i=6; i<dataSet.nRows(); ++i) {
            labels.add(1);
        }

        classifier.train(dataSet, labels);

        r = new RowDataSet<>();
        r.add(3.1, 2.2);
        Integer classIdx =  classifier.predict(r);

        System.out.println("Point "+r+" has class index "+ classIdx);

        r = new RowDataSet<>();
        r.add(9.1, 6.2);
        classIdx =  classifier.predict(r);

        System.out.println("Point "+r+" has class index "+ classIdx);

    }
}
