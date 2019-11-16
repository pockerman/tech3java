package maths;

import maths.functions.LinearVectorPolynomial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinearVectorPolynomialTest {

    /**
     * Test Scenario: Application creates a polynomial of order 3
     * Expected Output: Polynomial should be created
     */
    @Test
    public void createValidPolynomial(){
        LinearVectorPolynomial poly = new LinearVectorPolynomial(3);
        assertEquals("Invalid polynomial order", poly.numCoeffs(), 4);
    }
}
