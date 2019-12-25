package maths.errorfunctions;

import base.CommonConstants;
import datastructs.maths.DenseMatrixSet;
import datastructs.maths.RowBuilder;
import datastructs.maths.Vector;
import datastructs.utils.RowType;
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
        DenseMatrixSet<Double> dataSet = new DenseMatrixSet(RowType.Type.VECTOR, new RowBuilder(), labels.size(), hypothesis.numCoeffs(), 1.0);

        double sseError = sseVectorFunction.evaluate(dataSet, labels);
        double expected = 36.0;
        assertEquals(sseError, expected, CommonConstants.getTol());

    }
}
