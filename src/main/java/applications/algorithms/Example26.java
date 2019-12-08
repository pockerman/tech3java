package applications.algorithms;


import datastructs.adt.ArrayStack;

/** Category: Algorithms
 * ID: Example26
 * Description: Balanced brackets
 * Taken From: HackerRank Balanced Brackets
 * Details:
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * Two brackets are considered to be a matched pair if the an
 * opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type.
 * There are three types of matched pairs of brackets: [], {}, and ().
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 * The pair of square brackets encloses a single,
 * unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 *
 *     It contains no unmatched brackets.
 *     The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 */

public class Example26 {

    public static String matched(String val){

        if(val.charAt(0) == '}' || val.charAt(0) == ')' ||
                val.charAt(0) == ']'){
            return "NO";
        }

        if(val.charAt(val.length()-1) == '{' || val.charAt(val.length()-1) == '(' ||
                val.charAt(val.length()-1) == '['){
            return "NO";
        }

        String result = "YES";

        ArrayStack<Character> closing_bracks = new ArrayStack<Character>(val.length());
        ArrayStack<Character> stack = new ArrayStack<Character>(val.length());

        for(int i=0; i<val.length(); ++i){

            stack.push(val.charAt(i));
        }


        while(stack.empty() != true){

            char last = stack.access_top();

            if( last == ')' || last == '}' || last == ']') {
                stack.pop();
                closing_bracks.push(last);
            }
            else if (last == '(') {
                if (closing_bracks.size() != 0 && closing_bracks.access_top() == ')') {
                    stack.pop();
                    closing_bracks.pop();
                } else {
                    return "NO";
                }
            }
            else if ( last == '[') {
                    if (closing_bracks.size() != 0 && closing_bracks.access_top() == ']') {
                        stack.pop();
                        closing_bracks.pop();
                    } else {
                        return "NO";
                    }
            }
            else if(last == '{') {
                if (closing_bracks.size() != 0 && closing_bracks.access_top() =='}'){
                    stack.pop();
                    closing_bracks.pop();
                }
                else{
                    return "NO";
                }
            }

        }

        return result;
    }


    public static void main(String[] args){

        String[] strings = { "{[()]}",
         "{[(])}", "{{[[(())]]}}",
         "[](){()}",  "()",
         "({}([][]))[]()",
         "{)[](}]}]}))}(())(",
         "([[)"};

        String[] answers = { "YES", "NO", "YES", "YES",  "YES",
                "YES", "NO",  "NO"};

        for(int s=0; s<strings.length; ++s){

            String answer = Example26.matched(strings[s]);
            System.out.println("String "+strings[s]+ " should be "+answers[s]+" and found: "+answer);
        }
    }
}
