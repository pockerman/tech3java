package datastructs;

import datastructs.adt.*;
import datastructs.maths.DenseMatrixTestRunner;
import datastructs.maths.MatrixVectorOperationsTestRunner;
import datastructs.maths.VectorOperationsTestRunner;
import datastructs.maths.VectorTestRunner;
import maths.LinearVectorPolynomialTestRunner;

public class AllTestsRunner {

    public static void main(String[] args) {

        VectorTestRunner.run(args);
        VectorOperationsTestRunner.run(args);
        DenseMatrixTestRunner.run(args);
        MatrixVectorOperationsTestRunner.run(args);
        ArrayStackTestRunner.run(args);
        ArrayQueueTestRunner.run(args);
        SingleLinkedListTestRunner.run(args);
        BinaryTreeTestRunner.run(args);
        AVLTreeTestRunner.run(args);
        MatrixDataSetTestRunner.run(args);
        LinearVectorPolynomialTestRunner.run(args);
        RingBufferTestRunner.run(args);
    }
}
