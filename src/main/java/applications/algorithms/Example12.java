package applications.algorithms;


import java.util.ArrayList;

/** Category: Algorithms
 * ID: Example12
 * Description: Compute the equivalence classes of a list of numbers
 * Taken From: Matters Computational: https://www.jjj.de/fxt/fxtbook.pdf by Jorg Arndt
 * Details:
 * TODO
 */
public class Example12 {

    /**
     * Choose an integer m ≥ 1
     * Two integers a and b will be equivalent if a − b is an integer multiple of m (with m = 1 all integers are in the same class).
     * We can choose the numbers 0, 1 . . . , m − 1 as representatives of the m classes obtained. See the book mentioned above
     */
    public static boolean modulo_equivalence(int a, int b, int modulo){
        if((a-b)%modulo == 0){
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> compute_equivalnce(ArrayList<Integer> list, int modulo){

        ArrayList<Integer> equivalence = new ArrayList<>(list.size());

        // each integer initially goes in its own class
        for (int i = 0; i < list.size(); i++) {
            equivalence.add(i);
        }

        for (int i = 1; i < list.size(); i++) {

            int j = 0;

            while(! Example12.modulo_equivalence(list.get(i), list.get(j), modulo)){
                ++j;
            }

            equivalence.set(i, equivalence.get(j));
        }
        return equivalence;
    }

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        ArrayList<Integer> even = Example12.compute_equivalnce(list, 2);

        for (int i = 0; i < even.size(); i++) {

            System.out.println("For integer "+list.get(i)+" equivalence class is: "+even.get(i));
        }

        System.out.println(" ");
        ArrayList<Integer> multipleOfThree = Example12.compute_equivalnce(list, 3);

        for (int i = 0; i < even.size(); i++) {

            System.out.println("For integer "+list.get(i)+" equivalence class is: "+multipleOfThree.get(i));
        }
    }

}
