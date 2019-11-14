package algorithms.optimizers;

import algorithms.IterativeAlgorithmResult;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.IVectorErrorRealFunction;
import maths.IVectorRealFunction;

public class BatchGradientDescent implements ISupervisedOptimizer {

    /**
     * Constructor
     */
    public BatchGradientDescent(GDInput input){

        this.input = input;
    }

    /**
     * Optimize the weights of the given hypothesis function
     * by minimizing the given error metric over the provided dataset
     */
    public IterativeAlgorithmResult optimize(final DenseMatrix data, final Vector y, IVectorRealFunction f){

        IterativeAlgorithmResult reslt = new IterativeAlgorithmResult();
        reslt.numThreadsUsed = 1;

        // compute the value of f with the current weights
        double jOld = this.input.errF.evaluate(data, y);
        double jCurr = 0.0;

        Vector coeffs = f.getCoeffs();

        for(int itr=0; itr<this.input.numIterations; ++itr){

            //the gradients of the error function.
            Vector jGrads = this.input.errF.gradients(data, y);

            // update the
            for(int c=0; c<coeffs.size(); ++c){
                coeffs.add(c, -this.input.eta*jGrads.get(c));
            }

            jCurr = this.input.errF.evaluate(data, y);
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
