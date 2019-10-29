package applications.algorithms;


import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci sequence calculation
 */

public class Example3 {

    public static  int recursive_fib(int n){

        if(n < 0){
            throw new IllegalArgumentException("Cannot calculate Fibonacci sequence for negative numbers");
        }

        int[] rslt_base = {0, 1};

        if(n < 2){
            return rslt_base[n];
        }
        return recursive_fib(n-1) + recursive_fib(n-2);
    }

    public static  int iterative_fib(int n){

        if(n < 0){
            throw new IllegalArgumentException("Cannot calculate Fibonacci sequence for negative numbers");
        }

        int[] rslt_base = {0, 1};

        if(n < 2){
            return rslt_base[n];
        }
        int previous = 1;
        int previous_previous = 0;
        int rslt = 0;

        for(int i=2; i<=n; ++i){

            rslt = previous + previous_previous;
            previous_previous = previous;
            previous = rslt;
        }

        return rslt;
    }

    public static  int memo_fib(int n){

        if(n < 0){
            throw new IllegalArgumentException("Cannot calculate Fibonacci sequence for negative numbers");
        }

        Map<Integer, Integer> values = new HashMap<>();
        values.put(0, 0);
        values.put(1, 1);

        if( !values.containsKey(n)){
            values.put(n, memo_fib(n-1) + memo_fib(n-2));
        }

        return values.get(n);
    }

    public static  void main(String[] args){

        int rslt = Example3.recursive_fib(5);

        if (rslt != 5){
            System.out.println("Recursive Fibonacci: Invalid Fibonacci result " + rslt + "not equal to 5");
        }

        rslt = Example3.iterative_fib(5);

        if (rslt != 5){
            System.out.println("Iterative Fibonacci: Invalid Fibonacci result " + rslt + "not equal to 5");
        }

        rslt = Example3.memo_fib(5);

        if (rslt != 5){
            System.out.println("Memo Fibonacci: Invalid Fibonacci result " + rslt + "not equal to 5");
        }


    }
}
