package maths.errorfunctions;

import base.CommonConstants;
import datastructs.maths.DenseMatrix;
import datastructs.maths.Vector;
import maths.functions.LinearVectorPolynomial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SSEVectorFunctionTest {

    /**
     * Test Scenario: Application attempts to initialize SSEVectorFunction
     *                with null hypothesis function
     * Expected Output: IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullHypothesisFunction(){
        SSEVectorFunction sseVectorFunction = new SSEVectorFunction(null);
    }

    /**
     * Test Scenarion Application want to compute the SSE of a given vector
     * Expected Output: SSE should be computed properly
     */
    @Test
    public void testValidSSEComputation(){

        LinearVectorPolynomial hypothesis = new LinearVectorPolynomial(3);
        hypothesis.setCoeffs(new Vector(hypothesis.numCoeffs(), 1.0));

        SSEVectorFunction sseVectorFunction = new SSEVectorFunction(hypothesis);
        Vector labels = new Vector(4, 1.0);
        DenseMatrix dataSet = new DenseMatrix(labels.size(), hypothesis.numCoeffs(), 1.0);

        double sseError = sseVectorFunction.evaluate(dataSet, labels);

        double testError = 0.0;
        for(int rowIdx=0; rowIdx<dataSet.m(); ++rowIdx){
            Vector row = dataSet.row(rowIdx);
            double diff = labels.get(rowIdx) - hypothesis.evaluate(row);
            diff *= diff;
            testError += diff;
        }

        testError /= dataSet.m();
        assertEquals(sseError, testError, CommonConstants.getTol());

    }
}
