package applications.algorithms;

import datastructs.adt.SingleLinkedList;

/** Category: Algorithms
 * ID: Example 1
 * Description: Delete duplicated elements from sorted linked list
 * Taken From: Question 44 Coding Interviews Questions, Analysis and Solutions
 * Details:
 * TODO
 */

public class Example1 {


    public static void deleteDuplicateElements(SingleLinkedList<Integer> list){

        SingleLinkedList<Integer>.Node previous = null;
        SingleLinkedList<Integer>.Node current = list.front();
        SingleLinkedList<Integer>.Node head = list.front();


        while(current != null){

            SingleLinkedList<Integer>.Node next = current.getNext();

            boolean needDelete = false;

            if(next != null && next.getData().equals(current.getData())){

                needDelete = true;
            }

            if(!needDelete){
                // simply move forward
                previous = current;
                current = next;
            }
            else{

                int value = current.getData();
                SingleLinkedList<Integer>.Node pToBeDeleted = current;

                while(pToBeDeleted != null && pToBeDeleted.getData().equals(value)) {

                    next = pToBeDeleted.getNext();
                }

                pToBeDeleted = next;
                if(previous == null) {
                    head = next;
                }
                else {
                    previous.setNext(next);
                }

                current = next;

            }
        }

    }

    public static void main(String[] args){

        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        // create a sorted linked list
        list.pushBack(5);
        list.pushBack(4);
        list.pushBack(4);
        list.pushBack(3);
        list.pushBack(3);
        list.pushBack(3);
        list.pushBack(2);
        list.pushBack(1);

        Example1.deleteDuplicateElements(list);
    }
}
