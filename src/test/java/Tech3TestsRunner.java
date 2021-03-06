import datastructs.AllDataStructsTestsRunner;
import maths.AllMathsTestRunner;
import parallel.partitioners.RangePartitionerTestRunner;
import utils.ListUtilsTestRunner;

public class Tech3TestsRunner {

    public static void main(String[] args) {

        AllDataStructsTestsRunner.run(args);
        AllMathsTestRunner.run(args);
        ListUtilsTestRunner.run(args);
        RangePartitionerTestRunner.run(args);
    }
}
