package applications.ml;

import algorithms.utils.DefaultIterativeAlgorithmController;
import base.CommonConstants;
import datastructs.interfaces.IVector;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.DistanceCalculator;
import maths.EuclideanVectorCalculator;
import maths.functions.generators.IRandomGenerator;
import maths.functions.generators.UniformRandomGenerator;
import ml.clustering.KMeans;
import ml.clustering.KMeansInput;

/** Category: Machine Learning
 * ID: Example11
 * Description: Clustering with ```KMeans```
 * Taken From:
 * Taken From:
 * Details:
 * TODO
 */
public class Example11 {

    public static void main(String[] args){

        //some synthetic data
        DenseMatrix matrix = new DenseMatrix(6, 2, 0.0);
        matrix.set(0, 1.0, 2.0);
        matrix.set(1, 1.0, 4.0);
        matrix.set(2, 1.0, 0.0);
        matrix.set(3, 10.0, 2.0);
        matrix.set(4, 10.0, 2.0);
        matrix.set(5, 10.0, 0.0);

        KMeansInput input = new KMeansInput();
        input.k = 2;
        input.iterationContorller = new DefaultIterativeAlgorithmController(10, CommonConstants.getTol());

        KMeans<IVector, Double> kmeans = new KMeans<>(input);

        DistanceCalculator<IVector<Double>, Double> similarity = new EuclideanVectorCalculator<Double>();
        IRandomGenerator randomGenerator = new UniformRandomGenerator();

        kmeans.cluster(matrix, similarity, randomGenerator);


    }
}
