package datastructs.adt;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ArrayQueueTestRunner {

    public static void run(String[] args){

        System.out.println("============================");
        System.out.println("Start executing ArrayQueue tests");

        Result result = JUnitCore.runClasses(ArrayQueueTest.class);

        if( !result.wasSuccessful()) {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        else{
            System.out.println("\tAll tests passed: "+ result.getRunCount());
        }

        System.out.println("\tTest run time: "+ result.getRunTime());
        System.out.println("Done....");
        System.out.println("============================");

    }

    public static void main(String[] args) {

        ArrayQueueTestRunner.run(args);
    }
}
