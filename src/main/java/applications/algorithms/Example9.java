package applications.algorithms;

import datastructs.adt.ArrayStack;

/**
 * Demonstrates how to use stacks to solve the
 * Towers of Hanoi problem
 */
public class Example9 {

    public class Disk
    {
        int size = 0;

        Disk(int size)
        {
            this.size = size;
        }
    }

    public static void run(String[] args){

        Example9 game = new Example9();
        ArrayStack<Disk> peg1 = new ArrayStack<Disk>(10);

        for(int i=0; i< peg1.capacity(); ++i){
            peg1.push(game.new Disk(peg1.capacity() - i));
        }

        ArrayStack<Disk> peg2 = new ArrayStack<Disk>(10);
        ArrayStack<Disk> peg3 = new ArrayStack<Disk>(10);
    }

    public static  void main(String[] args){
        Example9.run(args);
    }
}
