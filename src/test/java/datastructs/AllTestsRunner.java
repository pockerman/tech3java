package datastructs;

import datastructs.adt.ArrayQueueTestRunner;
import datastructs.maths.VectorOperationsTestRunner;
import datastructs.maths.VectorTestRunner;
import datastructs.adt.ArrayStackTestRunner;

public class AllTestsRunner {

    public static void main(String[] args) {

        VectorTestRunner.run(args);
        VectorOperationsTestRunner.run(args);
        ArrayStackTestRunner.run(args);
        ArrayQueueTestRunner.run(args);
    }
}
