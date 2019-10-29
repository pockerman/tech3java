package applications.algorithms;

import java.util.ArrayList;

/** Category: Algorithms
 * ID: Example 2
 * Description: Vanilla implementation of binary search
 * Taken From:
 * Details:
 * TODO
 */
public class Example2 {


    /**
     * Search if the list contains the given value
     */
    public static int search(final ArrayList<Integer> list, int value){

        int low = 0;
        int high = list.size()-1;

        while( low != high){

            int middle = (low + high)/2;

            if( list.get(middle) < value){
                // move to larger items
                low = middle + 1 ;
            }
            else{
                high = middle ;
            }
        }

        if(list.get(high) >= value){
            return high;
        }

        return -1;
    }

    public  static  void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i< 15; ++i){
            list.add(i);
        }

        int value = 0;
        int idx = Example2.search(list, value);

        System.out.println("Value " + value + " is at  index: "+idx);

        value = 14;
        idx = Example2.search(list, value);

        System.out.println("Value " + value + " is at  index: "+idx);


        value = 7;
        idx = Example2.search(list, value);

        System.out.println("Value " + value + " is at  index: "+idx);

    }
}
