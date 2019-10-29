package applications.algorithms;

import java.util.ArrayList;

/** Category: Algorithms
 * ID: Example11
 * Description: Partition an array into odds and evens
 * Taken From: Question 45 Coding Interviews Questions, Analysis and Solutions
 * Details:
 * TODO
 */
public class Example11 {


    public static void partition(ArrayList<Integer> list){

        if(list == null || list.size() <= 1){
            return;
        }

        int start = 0;
        int end = list.size() - 1;

        while(start < end){

           // move start forward until it finds an even
            while(start < end && (list.get(start) & 0x1) != 0){
                start++;
            }


            // move end it finds an odd
            while(start < end && (list.get(end) & 0x1) == 0){
                end--;
            }

            if(start < end){
                int tmp = list.get(start);
                list.set(start, list.get(end));
                list.set(end, tmp);
            }
        }
    }

    public  static  void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i< 15; ++i){
            list.add(i);
        }

        System.out.println("List before partitioning\n");

        for(int i=0; i<list.size(); ++i){
            System.out.print(i + " , ");

        }

        System.out.println("\n");
        Example11.partition(list);
        System.out.println("List after partitioning\n");

        for(int i=0; i<list.size(); ++i){
            System.out.print(list.get(i) + " , ");
        }

        System.out.println("\n");
    }
}
