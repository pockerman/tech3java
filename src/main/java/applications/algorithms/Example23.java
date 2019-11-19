package applications.algorithms;

import datastructs.adt.SingleLinkedList;

/** Category: Algorithms
 * ID: Example21
 * Description: You're given the pointer to the head node of a sorted linked list, where the data in the nodes is in ascending order.
 *              Delete as few nodes as possible so that the list does not contain any value more than once.
 *
 * Taken From: HackerRank Get Node Value
 * Details:
 * TODO
 */
public class Example23 {

    public static SingleLinkedList<Integer> removeDuplicates(final  SingleLinkedList<Integer> list){

        SingleLinkedList<Integer>.Node  current = list.front().getNext();
        SingleLinkedList<Integer>.Node  previous = list.front();

        SingleLinkedList<Integer> newList = new SingleLinkedList<>();
        newList.pushBack(previous.getData());

        while(current != null){

            Integer data1 = current.getData();
            Integer data2 = previous.getData();

            if(data1 == data2){

                previous.setNext(current.getNext());
                current = current.getNext();
            }
            else{

                newList.pushBack(current.getData());
                previous = previous.getNext();
                current = current.getNext();
            }

        }

        return newList;
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


        SingleLinkedList<Integer> uniqueVals = Example23.removeDuplicates(list);
        System.out.println("Unique values size: "+uniqueVals.size());
        uniqueVals.print();
    }
}
