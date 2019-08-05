/**
 * @author James Caldwell
 * @version  3/23/2015
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Palindrome {




    public static void main(String[] args){

       boolean done = false;
        Scanner scan = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
        Queue queue = new LinkedList();

        while (!done) {

            System.out.println("\nType in a  palindrome.\nType done to quit.\n");

            String input = scan.nextLine();


            if(input.equals("done"))
                done = true;

            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }

            String reverseStack = "";
            String reverseQueue = "";

            while (!stack.isEmpty()) {
                reverseStack += stack.pop();
            }


            for (int i = input.length()-1; i >=0; i--) {
                queue.add(input.charAt(i));
            }



            while (!queue.isEmpty()) {
                reverseQueue = reverseQueue + queue.remove();
            }

            if (input.equals(reverseStack) && input.equals(reverseQueue))
                System.out.println(input + " is a palindrome.");
            else
                System.out.println(input + " is not a palindrome.");

        }
    }
}
