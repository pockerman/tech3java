package applications.algorithms;


import java.util.ArrayList;

/** Category: Algorithms
 * ID: Example13
 * Description: Test if a given string is a palindrome
 * Taken From:
 * Details:
 * TODO
 */
public class Example13 {


    public static boolean isPalindrome(String s){

        if(s == null ){
            throw new NullPointerException("Null string given");
        }

        char[] data = s.toLowerCase().toCharArray();

        // invert the string
        int start = 0;
        int end = s.length()-1;
        int middle = s.length() >> 1;

        for (int i = 0; i < middle; ++i) {

            char temp = s.charAt(i);
            data[i] = data[end];
            data[end--] = temp;
        }

        String other = new String(data);
        return other.equals(s);
    }

    public  static  void main(String[] args){

       String s = "eve";

       boolean palindrome = isPalindrome(s);
       System.out.println("String " +s + (palindrome ? " is" : " is not") +" a palindrome" );
       System.out.println("\n");

       s = "Alex";
       palindrome = isPalindrome(s);
       System.out.println("String " +s + (palindrome ? " is" : " is not") +" a palindrome" );
       System.out.println("\n");

        s = "A";
        palindrome = isPalindrome(s);
        System.out.println("String " +s + (palindrome ? " is" : " is not") +" a palindrome" );
        System.out.println("\n");
    }
}
