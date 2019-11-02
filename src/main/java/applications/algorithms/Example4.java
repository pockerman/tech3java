package applications.algorithms;
import java.util.Scanner;

/** Category: Algorithms
 * ID: Example 4
 * Description: Finds the first non-repeated character in a
 *              user specified string. It assumes ASCII characters
 * Taken From:
 * Details:
 * TODO
 */


public class Example4 {

    public static void find(String str){

        if(str == null){

            throw new NullPointerException("Input string instance in null");
        }

        if(str == ""){

            System.out.println("Empty string was specified....");
            return;
        }

        // we can have as much as 256 ASCII characters
        int[] vals = new int[256];

        for(int i=0; i<vals.length; ++i){
            vals[i] = 0;
        }

        for(int i=0; i<str.length(); ++i){

            int val = str.charAt(i);
            vals[val] += 1;
        }

        for(int i=0; i<str.length(); ++i){

            int val = str.charAt(i);
            if(vals[val] == 1){

                System.out.println("First non repeated character is: "+str.charAt(i));
                break;
            }
        }

    }


    public static void main(String[] arg){

        Scanner scanner = new Scanner(System. in);
        String inputString = scanner.nextLine();

        System.out.println("You entered: " + inputString);

        find(inputString);


    }
}
