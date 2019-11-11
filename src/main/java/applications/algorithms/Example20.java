package applications.algorithms;

/** Category: Algorithms
 * ID: Example20
 * Description: Given an array and a value remove all instances of
 *              that value in place and return the new array length. For example {4,3,5,1,2,3,6}
 *              should become {4,3,1,3,6} after removing 2
 * Taken From: Question 46 Coding interviews Questions, Analysis and Solutions
 * Details:
 * TODO
 */
public class Example20 {

    /**
     * remove value from the given array and return the new length
     */
    public static int remove(int[] array, int value){

        int newLength = 0;

        for(int i=0; i<array.length; ++i){
            if(array[i] != value){
                array[newLength++] = array[i];
            }
        }

        return newLength;
    }

    public static void main(String[] args){

        int[] array = new int[]{4,3,5,1,2,3,6};

        System.out.println("Array length: "+array.length);
        System.out.println("New array length: "+Example20.remove(array, 2));
    }
}
