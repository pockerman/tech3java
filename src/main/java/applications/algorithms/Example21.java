package applications.algorithms;

import datastructs.adt.SingleLinkedList;

/** Category: Algorithms
 * ID: Example21
 * Description: Merge two sorted linked lists
 * Taken From:
 * Details:
 * TODO
 */
public class Example21 {

    public static  SingleLinkedList<Integer> mergeLinkedLists(SingleLinkedList<Integer> list1, SingleLinkedList<Integer> list2){

        if(list1 == null && list2 == null){
            return new SingleLinkedList<>();
        }

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        SingleLinkedList<Integer> result = new SingleLinkedList<>();

        SingleLinkedList<Integer>.Node head1 = list1.front();
        SingleLinkedList<Integer>.Node head2 = list2.front();

        while( head1 != null && head2 != null){

            Integer val1 = head1.getData();
            Integer val2 = head2.getData();

            System.out.println(" value1: "+val1+" value2: "+val2);

            if( val1 < val2){
                result.pushBack(val1);
                head1 = head1.getNext();
            }
            else{
                result.pushBack(val2);
                head2 = head2.getNext();
            }
        }


        // pick up what is left
        while ( head1 != null ){

            result.pushBack(head1.getData());
            head1 = head1.getNext();

        }

        while ( head2 != null ){

            result.pushBack(head2.getData());
            head2 = head2.getNext();

        }

        return result;
    }

    public static void main(String[] args){

        SingleLinkedList<Integer> list1 = new SingleLinkedList<>();
        list1.pushBack(1);
        list1.pushBack(2);
        list1.pushBack(3);
        list1.pushBack(6);
        list1.pushBack(7);

        SingleLinkedList<Integer> list2 = new SingleLinkedList<>();
        list2.pushBack(1);
        list2.pushBack(4);
        list2.pushBack(5);
        list2.pushBack(6);
        list2.pushBack(7);
        list2.pushBack(8);
        list2.pushBack(9);

        SingleLinkedList<Integer> result = Example21.mergeLinkedLists(list1, list2);
        result.print();

    }
}
