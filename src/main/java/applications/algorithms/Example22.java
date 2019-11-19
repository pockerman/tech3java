package applications.algorithms;

import datastructs.adt.SingleLinkedList;

import java.util.List;

/** Category: Algorithms
 * ID: Example21
 * Description: You’re given the pointer to the head node of a linked list and a specific position.
 *              Counting backwards from the tail node of the linked list, get the value of the node at the given position.
 *              A position of 0 corresponds to the tail, 1 corresponds to the node before the tail and so on.
 * Taken From: HackerRank Get Node Value
 * Details:
 * TODO
 */
public class Example22 {


    public static  void main(String[] args){

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int i = 0; i < 15; i++) {
            list.pushBack(i);
        }

        // get the list items as an array
        List<Integer> data = list.getAsList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Item is: "+data.get(list.size()-1 - i));
        }


    }
}
