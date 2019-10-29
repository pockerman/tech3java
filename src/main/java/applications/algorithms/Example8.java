package applications.algorithms;
import datastructs.adt.ArrayStack;

/**
 * Demonstrates how to reverse an array using a stack
 * Such an approach takes O(N) time but it requires
 * O(N) extra space
 */
public class Example8 {


    public static void run(String[] args){

        int[] array = new int[20];

        for(int i=0; i<array.length; ++i){
            array[i] = i;
        }

        ArrayStack<Integer> stack = new ArrayStack<Integer>(array.length);

        for(int i=0; i<stack.size(); ++i){
            stack.push(array[i]);
        }

        for(int i=0; i<stack.size(); ++i){
            array[i] = stack.pop();
            System.out.println("At position: "+i+" array[i] "+array[i]);
        }
    }

    public static  void main(String[] args){
        Example8.run(args);
    }
}
