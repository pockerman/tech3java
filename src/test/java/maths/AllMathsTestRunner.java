package maths;

import maths.errorfunctions.SSEVectorFunctionTestRunner;

public class AllMathsTestRunner {

    public static void run(String[] args){


        LinearVectorPolynomialTestRunner.run(args);
        SSEVectorFunctionTestRunner.run(args);

    }

    public static void main(String[] args) {

        AllMathsTestRunner.run(args);
    }
}
