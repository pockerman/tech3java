package applications.threading;

import datastructs.maths.Vector;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Category: Threading
 * ID: Example4
 * Description: Illustrates ExecutorService
 * Taken From:
 *
 * Details:
 *
 *
 */
public class Example4 {


    public class LocalResult implements Callable<Double>{


        public LocalResult(Vector v, int start, int end){
            this.v = v;
            this.start = start;
            this.end = end;
        }

        @Override
        public Double call(){

            double rslt = 0.0;
            for(int i=this.start; i<this.end; ++i){

                rslt += this.v.get(i);
            }

            return rslt;
        }

        Vector v;
        int start;
        int end;

    }


    public static boolean tasksFinished(ArrayList<Future<Double>> tasks){

        for (int i = 0; i < tasks.size(); i++) {

            if(tasks.get(i) != null && !tasks.get(i).isDone()){
                return false;
            }
        }
        return true;
    }


    public static  void main(String[] args){

        Example4 exe = new Example4();
        Vector v = new Vector(200, 1.0);

        // number of threads
        int numTreads = 4;

        int localWorkSize = v.size()/numTreads;

        ExecutorService service = Executors.newFixedThreadPool(numTreads);

        ArrayList<Future<Double>> rslts = new ArrayList<>();
        ArrayList<LocalResult> tasks = new ArrayList<>();

        tasks.add(exe.new LocalResult(v, 0, localWorkSize));
        tasks.add(exe.new LocalResult(v, localWorkSize, 2*localWorkSize));
        tasks.add(exe.new LocalResult(v, 2*localWorkSize, 3*localWorkSize));
        tasks.add(exe.new LocalResult(v, 3*localWorkSize, 4*localWorkSize));

        for(int i=0; i<tasks.size(); ++i){
            rslts.add(service.submit(tasks.get(i)));
        }

        // wait until tasks are done
        while(!Example4.tasksFinished(rslts)){
            Thread.yield();
        }

        double sum = 0.0;
        for (Future<Double> rslt: rslts) {

            try {

                if(rslt != null) {
                    if (rslt.isDone()) {
                        sum += rslt.get();
                        rslt = null;
                    }
                }
            }
            catch(ExecutionException e){

            }
            catch(InterruptedException e){

            }
        }

        System.out.println("Sum of array elements is: "+sum);
        service.shutdownNow();

    }
}
