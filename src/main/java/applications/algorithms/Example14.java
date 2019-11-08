package applications.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Category: Algorithms
 * ID: Example14
 * Description: Fibonacci sequence calculation
 * Taken From:
 * Details:
 * TODO
 */
public class Example14 {


    public static List<Integer> fibSeq(int n){

        if(n == 0){
            return new ArrayList<>();
        }

        if(n == 1){
            return Arrays.asList(0);
        }

        if(n == 2){
            return Arrays.asList(0, 1);
        }

        List<Integer> list = new ArrayList<>(n);
        list.add(0);
        n = n-1;
        list.add(1);
        n = n-1;

        while( n > 0){
            int a = list.get(list.size() -1);
            int b = list.get(list.size() - 2);
            list.add(a + b);
            n = n - 1;
        }

        return list;
    }

    public static void main(String[] args){

        int n = 0;
        if(fibSeq(n).size() != 0){
            System.out.println("Invalid result for n = "+n);
        }

        n = 1;
        if(fibSeq(n).size() != 1){
            System.out.println("Invalid result for n = "+n);
        }

        n = 2;
        if(fibSeq(n).size() != 2){
            System.out.println("Invalid result for n = "+n);
        }

        n=8;

        if(!fibSeq(n).equals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13))){
            System.out.println("Invalid result for n = "+n);
        }

    }

}
