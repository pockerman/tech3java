package algorithms.optimizers;

import algorithms.AlgorithmResult;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.IVectorErrorRealFunction;
import maths.IVectorRealFunction;

public class BatchGradientDescent {

    public BatchGradientDescent(GDInput input){

        this.input = input;
    }

    public AlgorithmResult call(){
        return null;
    }

    /**
     * Optimize the weights of the given hypothesis function
     * by minimizing the given error metric over the provided dataset
     */
    public AlgorithmResult optimize(final DenseMatrix data, final Vector y, IVectorErrorRealFunction errF, IVectorRealFunction f){

        AlgorithmResult reslt = new AlgorithmResult();
        reslt.numThreadsUsed = 1;

        // compute the value of f with the current weights
        double jOld = errF.evaluate(data, y );
        double jCurr = 0.0;

        //the gradients of the error function.
        //List<Double> jGrads = BatchGradientDescent.initializeGradients(f.numCoeffs());
        Vector coeffs = f.getCoeffs();

        for(int itr=0; itr<this.input.numIterations; ++itr){

            Vector jGrads = errF.gradients(data, y);

            // update the
            for(int c=0; c<coeffs.size(); ++c){
                coeffs.set(c, -this.input.eta*jGrads.get(c));
            }

            jCurr = errF.evaluate(data, y);
            double error = Math.abs(jOld-jCurr);

            if(this.input.showIterations){

                System.out.println("BatchGD: iteration: "+itr);
                System.out.println("\tJold: "+jOld + " Jcur: " + jCurr);
                System.out.println("\terror |Jcur-Jold|: "+ error);
                System.out.println("\texit tolerance: "+this.input.tolerance);
            }

            reslt.numIterationsNeeded = itr + 1;
            if(error < this.input.tolerance){
                reslt.tolerance = error;
                reslt.converged = true;
                break;
            }

            jOld = jCurr;
            jGrads.zero();

        }

        return reslt;

    }

    GDInput input;
}
