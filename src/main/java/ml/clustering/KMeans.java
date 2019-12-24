package ml.clustering;

import algorithms.utils.IterativeAlgorithmResult;
import datastructs.interfaces.I2DDataSet;
import datastructs.interfaces.IVector;
import maths.DistanceCalculator;
import maths.functions.generators.IRandomGenerator;


import java.util.List;

public class KMeans<PointType, DistanceType>{

    public class Cluster<PointType>
    {
        public int id;
        public PointType centroid;
        public List<Integer> points;

        public <DataSetTp extends I2DDataSet<PointType>> void calculateCentorid(DataSetTp dataSet){

            for(int i=0; i<points.size(); ++i){
                centroid.add(i, dataSet.getRow(this.points.get(i)));
            }
        }
    }

    /**
      * Constructor
     */
    public KMeans(KMeansInput input){

        this.input = input;
    }

    public <DataSetType extends I2DDataSet<PointType>,
            SimilarityType extends DistanceCalculator<PointType, DistanceType>,
            RandomGeneratorType extends IRandomGenerator<PointType>>
    IterativeAlgorithmResult  cluster(final DataSetType data,
                                            final SimilarityType similarity, final RandomGeneratorType centroidGenerator){

        // assign the random centroids
        List<PointType> centroidsOld = centroidGenerator.generate(data, this.input.k);

        while(this.input.iterationContorller.continueIterations()){

            if(this.input.showIterations){
                System.out.println("KMeans iteration: " + this.input.iterationContorller.getCurrentIteration());
            }

            //for each point calculate its distance from the centroids
            for(int p=0; p<data.m(); ++p){

                this.clusterPoint(p, data.getRow(p), similarity);
            }

            //recalculate centroids
            DistanceType maxDiff = similarity.maxValue();
            for(int c=0; c<this.clusters.size(); ++c){

                this.clusters.get(c).calculateCentorid(data);

                DistanceType distance = similarity.calculate(centroidsOld.get(c), this.clusters.get(c).centroid);

                maxDiff = similarity.compareMin(distance, maxDiff);

                //if(distance < maxDiff){
                //    maxDiff = distance;
                //}
            }

            this.input.iterationContorller.updateResidual((double) maxDiff);

            // clear the points for each cluster and assign
            // to old centroids
            for(int c=0; c<this.clusters.size(); ++c){
                this.clusters.get(c).points.clear();
                centroidsOld.set(c, this.clusters.get(c).centroid);
            }

        }

        IterativeAlgorithmResult result =  this.input.iterationContorller.getState();
        return result;
    }

    private <PointType> void clusterPoint(int pointId, PointType point, final SimilarityType similarity){

        double dist = Double.MAX_VALUE;
        int clusterIdx = -1;
        for(int c=0; c<clusters.size(); ++c){

            double distance = similarity.calculate(point, clusters.get(c).centroid);

            if(distance < dist){
                distance = dist;
                clusterIdx = c;
            }

        }

        this.clusters.get(clusterIdx).points.add(pointId);

    }

    KMeansInput input;
    List<Cluster> clusters;
}
