package applications.numerics;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class Example3 {

    public static  void main(String[] args){

        // create an 1D row vector
        INDArray x = Nd4j.create(new double[]{2.0, 3.0, 52.0});

        // view the array
        System.out.println(x);

        // now that we have our vector set we can
        // do various operations on it

        // add 2 to every element
        x.addi(2.0);
        System.out.println(x);

        // subtract 5.0
        x.subi(5.0);
        System.out.println(x);

        // multiply with 10.0
        x.muli(10.0);
        System.out.println(x);

        // divide with 3.0
        x.divi(3.0);
        System.out.println(x);

    }


}
