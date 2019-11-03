package applications.algorithms;

import java.util.Arrays;

/** Category: Algorithms
 * ID: Example 16
 * Description: Test if a word is an anagram of another
 * Taken From:
 * Details:
 * TODO
 */
public class Example16 {


    public static boolean isAnagram(String w, String a){

        if(w == null || a == null){
            throw new NullPointerException("Both strings should be not null");
        }

        if(w.length() != a.length()){
            return false;
        }

        String lowerW = w.toLowerCase();
        char[] lowerWArray = lowerW.toCharArray();
        Arrays.sort(lowerWArray);
        String lowerA = a.toLowerCase();
        char[] lowerSortedAArray = lowerA.toCharArray();
        Arrays.sort(lowerSortedAArray);

        if((new String(lowerWArray)).equals(new String(lowerSortedAArray))){
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        String w = "eve";
        String a = "eve";

        System.out.println("String "+a+(isAnagram(w, a) ? " is ": " is not ")+ " an anagram of "+w);

        w = "Alex";
        a = "cat";

        System.out.println("String "+a+(isAnagram(w, a) ? " is ": " is not ")+ " an anagram of "+w);
    }
}
