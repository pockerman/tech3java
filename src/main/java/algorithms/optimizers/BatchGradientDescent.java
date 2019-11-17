package algorithms.optimizers;

import algorithms.utils.IterativeAlgorithmResult;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.functions.IVectorRealFunction;

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


        // compute the value of f with the current weights
        double jOld = this.input.errF.evaluate(data, y);
        double jCurr = 0.0;

        Vector coeffs = f.getCoeffs();

        while(this.input.iterationContorller.continueIterations()){

            //the gradients of the error function.
            Vector jGrads = this.input.errF.gradients(data, y);

            // update the
            for(int c=0; c<coeffs.size(); ++c){
                coeffs.add(c, -this.input.eta*jGrads.get(c));
            }

            f.setCoeffs(coeffs);

            jCurr = this.input.errF.evaluate(data, y);
            double error = Math.abs(jOld-jCurr);
            this.input.iterationContorller.updateResidual(error);

            if(this.input.showIterations){

                System.out.println("BatchGD: iteration: "+this.input.iterationContorller.getCurrentIteration());
                System.out.println("\tJold: "+jOld + " Jcur: " + jCurr);
                System.out.println("\terror |Jcur-Jold|: "+ error);
                System.out.println("\texit tolerance: "+this.input.iterationContorller.getExitTolerance());
            }

            jOld = jCurr;
            jGrads.zero();
        }

        IterativeAlgorithmResult reslt = this.input.iterationContorller.getState();
        reslt.numThreadsUsed = 1;
        return reslt;
    }

    GDInput input;
}
