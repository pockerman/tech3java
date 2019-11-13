package applications.threading;

import utils.IActor;
import utils.Pair;
import utils.PairBuilder;

/**
 * Category: Threading
 * ID: Example2
 * Description: Implement trapezoid rule using threads
 * Taken From: 
 * Details:
 * TODO
 */

public class Example2 {

    public static IActor<Double, Double> f = (Double a)->{return a*a;};

    class LocalIntegrator implements Runnable{


        public LocalIntegrator(Pair<Integer, Integer> range, double start, double h){

            this.range = range;
            this.start = start;
            this.h = h;
            this.localSum = 0.0;
        }

        @Override
        public void run() {

            for(int i= range.first; i< range.second; ++i){
                localSum += Example2.f.evaluate(start + i*h);
            }
        }

        public double getLocalSum(){
            return localSum;
        }

        private Pair<Integer, Integer> range;
        private double start;
        private double h;
        private double localSum;
    }


    public static void main(String[]  args) throws InterruptedException{

        // start interval
        double a = 0.0;

        // end interval
        double b = 1.0;

        // how many intervals
        int n = 200;

        // the discretization size
        double h = (b-a)/n;

        System.out.println("Discretization size: " + h);

        // number of threads
        int numTreads = 4;

        int localWorkSize = n/numTreads;

        System.out.println("Local work size: " + localWorkSize);

        // calculate the intervals
        Pair<Integer, Integer> range1 = PairBuilder.makePair(1, localWorkSize);
        Pair<Integer, Integer> range2 = PairBuilder.makePair(localWorkSize, 2*localWorkSize);
        Pair<Integer, Integer> range3 = PairBuilder.makePair(2*localWorkSize, 3*localWorkSize);
        Pair<Integer, Integer> range4 = PairBuilder.makePair(3*localWorkSize, 4*localWorkSize);

        // create the workers

        Example2 example2 = new Example2();

        LocalIntegrator integrator1 = example2.new LocalIntegrator(range1, a, h);
        LocalIntegrator integrator2 = example2.new LocalIntegrator(range2, a, h);
        LocalIntegrator integrator3 = example2.new LocalIntegrator(range3, a, h);
        LocalIntegrator integrator4 = example2.new LocalIntegrator(range4, a, h);

        Thread t1 = new Thread( integrator1 );
        Thread t2 = new Thread(integrator2 );
        Thread t3 = new Thread(integrator3 );
        Thread t4 = new Thread(integrator4 );

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        double sum = Example2.f.evaluate(a) * 0.5;

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        sum += integrator1.getLocalSum();
        sum += integrator2.getLocalSum();
        sum += integrator3.getLocalSum();
        sum += integrator4.getLocalSum();
        sum += Example2.f.evaluate(b) * 0.5;

        System.out.println("Integral calculated: "+sum*h);
    }
}
