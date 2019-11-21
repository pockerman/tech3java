package ml;

import maths.DistanceCalculator;
import parallel.partitioners.IPartitionePolicy;
import parallel.tasks.TaskBase;
import utils.ClassificationVoter;
import datastructs.adt.IDataSetWrapper;
import utils.Pair;

import java.util.*;

/**
 * KNNClassifier performs classification using the KNN algorithm
 */
public class KNNClassifier<DataSetType extends IDataSetWrapper,
                           DistanceType extends DistanceCalculator,
                           VoterType extends ClassificationVoter> {

    /**
     * Constructor
     */
    public KNNClassifier(int k, boolean copyDataset){
        this.k = k;
        this.copyDataset = copyDataset;
    }

    /**
     * How many neighbors the algorithm is using
     * @return
     */
    public int nNeighbors() {
        return this.k;
    }

    /**
     * Set the object that calculates the distance between instances in the dataset
     * @param distanceCalculator
     */
    public void setDistanceCalculator(DistanceType distanceCalculator){
        this.distanceCalculator = distanceCalculator;
    }

    /**
     * Set the object that calculates the class
     * @param voter
     */
    public void setMajorityVoter(VoterType voter){
        this.majorityVoter = voter;
    }

    /**
     * Train the model using the provided dataset
     */
    public void train(DataSetType dataSet, List labels){

        if(this.copyDataset){
            this.dataSet = (DataSetType) dataSet.copy();

        }
        else{
            this.dataSet = dataSet;
            this.labels = labels;
        }
    }

    /**
     * Predict the class of the given data point
     */
    public <PointType> Integer  predict(PointType point){

        if(this.majorityVoter == null){
            throw new IllegalStateException(" Majority voter has not been set");
        }

        if(this.distanceCalculator == null){
            throw new IllegalStateException("Distance calculator has not been set");
        }

        // loop over the items in the dataset and compute distances
        for (int i = 0; i < this.dataSet.nRows(); i++) {

            this.majorityVoter.addItem(i, this.distanceCalculator.calculate(this.dataSet.getRow(i), point));
        }

        // get the top k results
        List<Pair<Integer, Double>> results = this.majorityVoter.getResult(this.k);
        this.majorityVoter.clear();

        Map<Integer, Integer> idxMap = new HashMap<>();

        for(int i=0; i<results.size(); ++i){
            int classIdx = (int) this.labels.get(results.get(i).first);

            if(idxMap.containsKey(classIdx)){
                idxMap.put(classIdx, idxMap.get(classIdx) + 1);
            }
            else{
                idxMap.put(classIdx, 1);
            }
        }

        Map.Entry<Integer, Integer> maxEntry = Collections.max(idxMap.entrySet(),
                (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e1.getValue()
                .compareTo(e2.getValue()));
        return maxEntry.getKey();
    }


    public class KNNTask<PointType> extends TaskBase<List<Integer>>
    {

        public KNNTask(){
            
        }

        @Override
        public void run(){

            // loop over the items in the dataset and compute distances
            // we don't want to loop over all rows but only to the
            // rows attached to the task. This is implicitly known
            // by the partitioning of the data set
            IPartitionePolicy partitionePolicy = this.dataSet.getPartitionPolicy();
            List<Integer> rows = partitionePolicy.getParition(this.taskId);

            for (int i = 0; i < rows.size(); i++) {

                this.majority.addItem(rows.get(i), this.distanceCalculator.calculate(this.dataSet.getRow(rows.get(i)), point));
            }

            this.finished = true;

            if(this.barrier != null){
                this.waitOnBarrier();
            }
        }

        /**
         * The id of the task
         */
        int taskId;

        /**
         * The point type the task is working on
         */
        PointType point;

        /**
         * The dataset the task is working on
         */
        private DataSetType dataSet;

        /**
         * How to get the majority set
         */
        private VoterType majority;

        /**
         * The distance used
         */
        private DistanceType distanceCalculator;

    }

    /**
     * Number of neighbors to consider
     */
    private int k;

    /**
     * flag indicating whether the dataset should be fully copied
     */
    boolean copyDataset;

    /**
     * The dataset
     */
    DataSetType dataSet;

    /**
     * The labels
     */
    List labels;

    /**
     * The distance used
     */
    DistanceType distanceCalculator;

    /**
     * How to get the majority set
     */
    VoterType majorityVoter;
}
