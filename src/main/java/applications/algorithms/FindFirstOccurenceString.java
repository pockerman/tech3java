package applications.algorithms;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Finds the first non-repeated character in a
 * user specified string.
 */

public class FindFirstOccurenceString {


    public static void findChar(String input) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        // populate the hash map
        for (int i = 0; i < input.length(); ++i) {

            char character = input.charAt(i);

            if (!map.containsKey(character)) {

                map.put(character, 1);
            } else {

                map.put(character, map.get(character) + 1);
            }
        }

        // one more loop to find the first non-repeated character
        for (int i = 0; i < input.length(); ++i) {

            char character = input.charAt(i);

            if (map.get(character) == 1) {
                System.out.println("First non repeated character in " + input + " is: " + character);
                break;
            }

        }
    }

    public static void main(String[] args){

        // read the input string from user
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner.nextLine();

        System.out.println("You entered: " + inputString);

        findChar(inputString);


    }
}
