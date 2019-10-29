package applications.algorithms;

import datastructs.adt.ArrayStack;

import java.util.Random;

/**
 * A train holds items for three different destinations
 * We need to sort the cars in such a way so that the cars
 * are grouped according to the destination
 */

public class Example10 {

    public static void run(String[] args) {
        Random random = new Random();
        random.setSeed(2);

        ArrayStack<Integer> input = new ArrayStack<Integer>(20);

        for (int i = 0; i < input.size(); ++i) {

            input.push(random.nextInt());
        }

        // holds items for destination 2
        ArrayStack<Integer> hold1 = new ArrayStack<Integer>(20);

        // holds items for destination 3
        ArrayStack<Integer> hold2 = new ArrayStack<Integer>(20);

        // holds items for destination 1
        ArrayStack<Integer> output = new ArrayStack<Integer>(20);

        for(int i=0; i<input.size(); ++i){

            Integer integer = input.pop();

            if(integer.intValue() == 2){
                hold1.push(integer);
            }
            else if(integer.intValue() == 3){
                hold2.push(integer);
            }
            else{
                output.push(integer);
            }
        }

        //assume that the items for destination 3 should go last
        //item with destination 1 after and first the items with
        // destination 2

        for(int i=0; i<hold2.size(); ++i){

            input.push(hold2.pop());
        }

        for(int i=0; i<output.size(); ++i){

            input.push(output.pop());
        }

        for(int i=0; i<hold1.size(); ++i){

            input.push(hold1.pop());
        }

    }

    public static  void main(String[] args){
        Example10.run(args);
    }

}
