package applications.threading;

import datastructs.maths.Vector;
import utils.Pair;
import utils.PairBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Category: Threading
 * ID: Example5
 * Description: Illustrates CyclicBarrier class
 * Taken From:
 *
 * Details:
 * A barrier is a synchronization mechanism which can be used to ensure that multiple threads are waiting on each other at a certain point.
 * Once all threads reach the synchronization point, the barrier is released and all threads can continue their work. Such a mechanism is
 * useful often in iterative algorithms where a tolerance has to be computed that depends on the result or operations of all the participating threads.
 *
 * The barrier is called cyclic because it can be re-used after the waiting threads are released.
 */

public class Example5 {

    public static final int NUM_THREADS = 4;

    /**
     * The CyclicBarrier used to synchronize the threads
     */
    CyclicBarrier barrier;
    List<LocalDotProduct> tasks;



    class AggregatorThread implements Runnable {

        public AggregatorThread(List<LocalDotProduct> tasks){
            this.tasks = tasks;
        }

        public double getSum(){
            return this.sum;
        }

        public boolean isDone(){
            return this.isDone;
        }

        @Override
        public void run() {

            String thisThreadName = Thread.currentThread().getName();
            System.out.println(thisThreadName + ": Computing sum from " + Example5.NUM_THREADS + " worker threads");

            for (LocalDotProduct threadResult : this.tasks) {
                    this.sum += threadResult.getLocalSum();
            }

            this.isDone = true;
            System.out.println();
            System.out.println(thisThreadName + ": Final result = " + this.sum);
        }

        List<LocalDotProduct> tasks;
        double sum = 0.0;
        boolean isDone = false;
    }

    class LocalDotProduct implements Runnable{


        /**
         * Constructor
         */
        public LocalDotProduct(Pair<Integer, Integer> range, Vector v1, Vector v2, CyclicBarrier barrier){

            this.range = range;
            this.v1 = v1;
            this.v2 = v2;
            this.localSum = 0.0;
            this.barrier = barrier;
        }

        @Override
        public void run() {

            for(int i= this.range.first; i< this.range.second; ++i){
                this.localSum += this.v1.get(i)*this.v2.get(i);
            }

            // now wait until all threads are summed
            try {

                System.out.println(Thread.currentThread().getName()  + " waiting for others to reach barrier.");
                this.barrier.await();
            }
            catch(InterruptedException e){
                System.out.println("InterruptedException: "+ e.getMessage());
            }
            catch(BrokenBarrierException e){
                System.out.println("BorkenBarrierException: "+ e.getMessage());
            }

        }

        public double getLocalSum(){
            return localSum;
        }

        private Pair<Integer, Integer> range;
        private Vector v1;
        private Vector v2;
        private double localSum;
        CyclicBarrier barrier;

    }

    public double compute(Vector v1, Vector v2){

        int localWorkSize = v1.size()/Example5.NUM_THREADS;

        System.out.println("Local work size: " + localWorkSize);

        // calculate the intervals
        Pair<Integer, Integer> range1 = PairBuilder.makePair(0, localWorkSize);
        Pair<Integer, Integer> range2 = PairBuilder.makePair(localWorkSize, 2*localWorkSize);
        Pair<Integer, Integer> range3 = PairBuilder.makePair(2*localWorkSize, 3*localWorkSize);
        Pair<Integer, Integer> range4 = PairBuilder.makePair(3*localWorkSize, 4*localWorkSize);

        this.tasks = new ArrayList<>(Example5.NUM_THREADS);

        // create the barrier and the threads
        AggregatorThread aggregatorThread = new AggregatorThread(this.tasks);
        this.barrier = new CyclicBarrier(Example5.NUM_THREADS, aggregatorThread);

        this.tasks.add(new LocalDotProduct(range1, v1, v2, this.barrier));
        this.tasks.add(new LocalDotProduct(range2, v1, v2, this.barrier));
        this.tasks.add(new LocalDotProduct(range3, v1, v2, this.barrier));
        this.tasks.add(new LocalDotProduct(range4, v1, v2, this.barrier));

        System.out.println("Spawning " + Example5.NUM_THREADS + " worker threads to compute ");

        for(int t=0; t<Example5.NUM_THREADS; ++t) {
            Thread thread = new Thread(this.tasks.get(t));
            thread.setName("Thread "+t);
            thread.start();
        }

        while(!aggregatorThread.isDone()){
            System.out.println("Not finished yet...");
        }
        return aggregatorThread.getSum();
    }


    public static void main(String[] args){

        Vector v1 = new Vector(200, 1.0);
        Vector v2 = new Vector(200, 1.0);

        Example5 example5 = new Example5();
        double dotProduct = example5.compute(v1, v2);
        System.out.println("Dot product computed: "+dotProduct);
    }



}
