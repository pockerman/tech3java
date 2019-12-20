package ml.clustering;

import algorithms.utils.IterativeAlgorithmResult;
import datastructs.interfaces.I2DDataSet;
import maths.DistanceCalculator;


import java.util.List;

public class KMeans<DataSetType extends I2DDataSet,
        SimilarityType extends DistanceCalculator, RandomGeneratorType>{

    public class Cluster<PointType>
    {
        public int id;
        public PointType centroid;
        public List<PointType> points;

    }

    /**
      * Constructor
     */
    public KMeans(KMeansInput input){

        this.input = input;
    }

    public IterativeAlgorithmResult  cluster(final DataSetType data,
                                            final SimilarityType similarity, final RandomGeneratorType centroidGenerator){

            // assign the random centroids

        while(this.input.iterationContorller.continueIterations()){

            if(this.input.showIterations){
                System.out.println("KMeans iteration: " + this.input.iterationContorller.getCurrentIteration());
            }

            //for each point calculate its distance from the centroids
            for(int p=0; p<data.m(); ++p){


                similarity.calculate(data.getRow(p), )
            }
        }


        IterativeAlgorithmResult result =  this.input.iterationContorller.getState();

        return result;
    }

    private <PointType> void clusterPoint(PointType point, final SimilarityType similarity){

        double dist = 0.0;
        for(int c=0; c<clusters.size(); ++c){

            double distance = similarity.calculate(point, clusters.get(c).centroid);
        }


    }

    KMeansInput input;
    List<Cluster> clusters;
}
