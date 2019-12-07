package applications.algorithms;

import datastructs.adt.ArrayStack;

import java.util.Scanner;

/** Category: Algorithms
 * ID: Example24
 * Description: Detect a cycle in a single linked list
 * Taken From: HackerRank Simple Text Editor
 * Details:
 *In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, .
 * You must perform operations of the following
 *
 * types:
 *
 * 1   append(W) - Append string W to the end of S
 * 2   delete(k) - Delete the last k characters of S
 * 3   print(k)  - Print the k-th character of S
 * 4   undo() - Undo the last (not previously undone) operation of type or , reverting
 *              to the state it was in prior to that operation.
 *
 * Input Format
 *
 */
public class Example25 {

    public static void main(String[] args){

        // An ArrayStack that holds the state of the editor
        // upd to 50 states can be held
        ArrayStack<String> stack = new ArrayStack<>(50);

        // initially the editor is empty
        String editor = "";

        boolean stop = false;
        Scanner input = new Scanner(System.in);

        while(!stop){

            System.out.println("Enter and operation: ");
            String input_type = input.nextLine();
            System.out.println("Input given: " + input_type);

            if(input_type.equals("append")){

                System.out.println("Enter append data: ");
                input_type = input.nextLine();

                stack.push(editor);

                // add some item  to the editor
                editor += input_type;
            }
            else if(input_type.equals("print")){
                System.out.println(editor);
            }
            else if(input_type.equals("delete")){
                System.out.println("Enter how many characters to delete: ");
                input_type = input.nextLine();
                int val = Integer.valueOf(input_type);
                stack.push(editor);
                editor = editor.substring(0, editor.length()-val);

            }
            else if(input_type.equals("undo")){

                editor = stack.pop();
            }
            else if(input_type.equals("stop")){
                System.out.println("Stopping:...");
                stop = true;
            }

        }


    }
}
