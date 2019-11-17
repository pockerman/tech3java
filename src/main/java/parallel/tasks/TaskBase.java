package parallel.tasks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public abstract class TaskBase<T> implements Callable<Double>, Runnable{

    /**
     * Constructor
     */
    protected TaskBase(CyclicBarrier barrier){
        this.barrier = barrier;
        this.finished = false;
    }

    /**
     * Constructor
     */
    protected TaskBase(){
        this.barrier = null;
        this.finished = false;
    }

    public void waitOnBarrier(){

        // now wait until all threads are summed
        try {

            if(this.barrier == null){
                throw new IllegalStateException("Attempt to use a null barrier");
            }
            this.barrier.await();
        }
        catch(InterruptedException e){
            System.out.println("InterruptedException: "+ e.getMessage());
        }
        catch(BrokenBarrierException e){
            System.out.println("BorkenBarrierException: "+ e.getMessage());
        }
    }

    public boolean isFinished(){
        return this.finished;
    }

    protected CyclicBarrier barrier;
    protected boolean finished;
}