package applications.algorithms;


import datastructs.adt.SingleLinkedList;

import java.util.ArrayList;
import java.util.List;

/** Category: Algorithms
 * ID: Example24
 * Description: Detect a cycle in a single linked list
 * Taken From: HackerRank Get Node Value
 * Details:
 * TODO
 */
public class Example24 {

    public static boolean hasCycle(final SingleLinkedList<Integer> list){

        List<SingleLinkedList<Integer>.Node> nodes = new ArrayList<>();
        SingleLinkedList<Integer>.Node head = list.front();

        while( head != null ){

            if( nodes.contains(head)){
                return true;
            }
            else{
                nodes.add(head);
            }

            head = head.getNext();
        }

        return false;
    }

    public static void main(String[] args){

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.pushBack(0);
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(2);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(5);
        list.pushBack(6);

        SingleLinkedList<Integer>.Node head = list.front();
        SingleLinkedList<Integer>.Node tail = list.tail();

        // create a cycle
        tail.setNext(head);

        System.out.println("List has cycle: "+Example24.hasCycle(list));

    }
}
