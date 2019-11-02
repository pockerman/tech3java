package applications.algorithms;

/** Category: Algorithms
 * ID: Example 15
 * Description: Factorial calculation without recursion
 * Taken From:
 * Details:
 * TODO
 */
public class Example15 {

    public static long factorial(int n){

        if(n < 0){
            throw new IllegalArgumentException("Cannot calculate factorial of negative number");
        }

        long rslt = 1;

        for (int i = 1; i <= n; ++i) {
            rslt *= i;

        }

        return rslt;
    }

    public static void main(String[] args){
        int n = 1;
        System.out.println("Factorial of "+n+" is "+Example15.factorial(n) + "\n");

        n = 10;
        System.out.println("Factorial of "+n+" is "+Example15.factorial(n) + "\n");
    }
}
