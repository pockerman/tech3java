package ml;

import datastructs.adt.IDataSetWrapper;
import maths.DistanceCalculator;
import parallel.partitioners.IPartitionePolicy;
import parallel.tasks.TaskBase;
import utils.ClassificationVoter;
import utils.Pair;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ThreadedKNNClassifier<DataSetType extends IDataSetWrapper,
                                   DistanceType extends DistanceCalculator,
                                   VoterType extends ClassificationVoter> extends KNNClassifier<DataSetType, DistanceType, VoterType> {

    /**
     * Constructor
     */
    public ThreadedKNNClassifier(int k, boolean copyDataset, ExecutorService executorService){
        super(k, copyDataset);
        this.executorService = executorService;

    }

    /**
     * Predict the class of the given data point
     */

    @Override
    public <PointType> Integer  predict(PointType point){

        if(this.majorityVoter == null){
            throw new IllegalStateException(" Majority voter has not been set");
        }

        if(this.distanceCalculator == null){
            throw new IllegalStateException("Distance calculator has not been set");
        }

        if(this.tasks.size() != this.dataSet.getPartitionPolicy().numPartitions()) {

            // generate tasks as many as the partitions of the dataset
            this.tasks = new ArrayList<>(this.dataSet.getPartitionPolicy().numPartitions());
        }

        List<Future<Integer>> futures = new ArrayList<>();

        // let's create the tasks and add them to the List
        for (int i = 0; i < this.dataSet.getPartitionPolicy().numPartitions(); i++) {

            this.tasks.add(new KNNTask<PointType>());
            futures.add( this.executorService.submit((Callable<Integer>)tasks.get(i)));
        }

        CompletableFuture.allOf(futures.get(0), futures.get(0) );
    }

    private ExecutorService executorService;

    /**
     * The class that represents the task to submit to the executor
     *
     */
    private class KNNTask<PointType> extends TaskBase<List<Integer>>
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
     * Private list that holds the tasks to submit
     */
    List<KNNTask> tasks;

}
