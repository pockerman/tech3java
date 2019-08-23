package datastructs;

import datastructs.adt.ArrayQueueTestRunner;
import datastructs.adt.SingleLinkedListTestRunner;
import datastructs.maths.DenseMatrixTestRunner;
import datastructs.maths.MatrixVectorOperationsTestRunner;
import datastructs.maths.VectorOperationsTestRunner;
import datastructs.maths.VectorTestRunner;
import datastructs.adt.ArrayStackTestRunner;

public class AllTestsRunner {

    public static void main(String[] args) {

        VectorTestRunner.run(args);
        VectorOperationsTestRunner.run(args);
        DenseMatrixTestRunner.run(args);
        MatrixVectorOperationsTestRunner.run(args);
        ArrayStackTestRunner.run(args);
        ArrayQueueTestRunner.run(args);
        SingleLinkedListTestRunner.run(args);
    }
}
