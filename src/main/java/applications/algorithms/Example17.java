package applications.algorithms;

import java.util.*;

/** Category: Algorithms
 * ID: Example 17
 * Description: Given a list of words get all the anagrams of a given string
 * Taken From:
 * Details:
 * TODO
 */
public class Example17 {


    public static List<String> getAnagrams(List<String> words, String a){

        if(words == null || a == null){
            throw new NullPointerException("Either list of words or word is null");
        }

        //create a Map with the signatures of the words
        Map<String, List<String>> wordSignature = new HashMap<>();

        for(String word : words){

            char[] arr = word.toLowerCase().toCharArray();
            Arrays.sort(arr);

            String sorted = new String(arr);
            if(wordSignature.containsKey(sorted)){
                wordSignature.get(sorted).add(word);
            }
            else{
                List<String> newList = new ArrayList<String>();
                newList.add(word);
                wordSignature.put(sorted, newList);
            }
        }

        // now that we sorted the words find the signature
        // of our word

        char[] arr = a.toLowerCase().toCharArray();
        Arrays.sort(arr);

        String sorted = new String(arr);

        if(wordSignature.containsKey(sorted)){
            return wordSignature.get(sorted);
        }

        List<String> list = new ArrayList<>();
        return list;
    }


    public static void main(String[] args){

        List<String> words = new ArrayList<>();
        words.add("eve");
        words.add("test");
        words.add("abba");
        words.add("efkllkfe");
        words.add("aaa");
        words.add("AAA");
        words.add("aba");
        words.add("aBA");
        words.add("emnnme");

        String a = "ABA";

        List<String> wordAnagrams = Example17.getAnagrams(words, a);

        System.out.println("Word "+a+" is the anagram of "+wordAnagrams.size()+ " words...");

        if(wordAnagrams.size() != 0){
            System.out.println("...these are");

            for (String s: wordAnagrams) {
                System.out.println(s);
            }
        }


        a = "Alex";

        wordAnagrams = Example17.getAnagrams(words, a);

        System.out.println("Word "+a+" is the anagram of "+wordAnagrams.size()+ " words...");

        if(wordAnagrams.size() != 0){
            System.out.println("...these are");

            for (String s: wordAnagrams) {
                System.out.println(s);
            }
        }

    }
}
