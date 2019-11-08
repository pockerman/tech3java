package applications.algorithms;

import datastructs.adt.SingleLinkedList;

/** Category: Algorithms
 * ID: Example 18
 * Description: Reverse single linked list in place
 * Taken From:
 * Details:
 * TODO
 */
public class Example18 {

    public static void reverse(SingleLinkedList<Integer> list){

        int middle = list.size() >> 1;

        for(int i=0; i<middle; ++i){

            SingleLinkedList<Integer>.Node node1 = list.get(i);
            SingleLinkedList<Integer>.Node node2 = list.get(list.size() - i -1);

            // we want to swap the data held by these two nodes
            Integer tmp = node1.getData();
            node1.setData(node2.getData());
            node2.setData(tmp);
        }

    }


    public static void main(String[] args){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.pushFront(i);
        }

        System.out.println("List before reversing...\n");
        linkedList.print();

        Example18.reverse(linkedList);

        System.out.println("\nList after reversing...\n");
        linkedList.print();



        linkedList = new SingleLinkedList<>();

        for (int i = 0; i < 11; i++) {
            linkedList.pushFront(i);
        }

        System.out.println("List before reversing...\n");
        linkedList.print();

        Example18.reverse(linkedList);

        System.out.println("\nList after reversing...\n");
        linkedList.print();
    }
}
