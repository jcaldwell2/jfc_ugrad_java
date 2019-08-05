/**
 * ScanTest.java -- tests some of the methods from the Scanner class.
 *
 * @author  James Caldwell
 * @version September 03/2014
 */
import java.util.Scanner;
public class ScannerTest
{
    public static void main(String[] args)
    {
        /*+++++++++++++++++++++++++++++++++++++++*/
        /* Using the Scanner class with a string */
        /*+++++++++++++++++++++++++++++++++++++++*/

        /*----------------*/
        /* Part 1 -- next */
        /*----------------*/

        // Test the next() method 
        final String STR1 = "abc XYZ   123  456, nice!  w1n";
        
        System.out.println("\nTest string: " + STR1);
        System.out.println();

        String  token;
        Scanner scan = new Scanner(STR1);

        token = scan.next();
        System.out.println(token);

        token = scan.next();
        System.out.println(token);

        token = scan.next();
        System.out.println(token);

        token = scan.next();
        System.out.println(token);

        token = scan.next();
        System.out.println(token);

        token = scan.next();
        System.out.println(token);

/*****
        System.out.println("\nTesting extra call to next\n");
        token = scan.next();
        System.out.println(token);
        System.out.println();
*****/

        /*------------------*/
        /* Part 2 - nextInt */
        /*------------------*/

        // Test the nextInt() method 
        final String STR2 = "123 456    789   w1n 999,";

/*****
        System.out.println("\nTest string: " + STR1);
        System.out.println();

        int num; 
        scan = new Scanner(STR2);
*****/
        

        /*+++++++++++++++++++++++++++++++++++++++++++++*/
        /* Using the Scanner class with keyboard input */
        /*+++++++++++++++++++++++++++++++++++++++++++++*/

        /*---------------*/
        /* Part 3 - next */
        /*---------------*/

/*****
        // read one string from the command line
        scan = new Scanner(System.in);

        System.out.print("\nEnter a string: ");
        token = scan.next();
        System.out.println(token);

        System.out.print("\nEnter a string: ");
        token = scan.next();
        System.out.println(token);

        System.out.print("\nEnter a string: ");
        token = scan.next();
        System.out.println(token);

*****/


/*****
        // read two strings from one line

        String token1, token2;

        System.out.print("\nEnter two strings separated by a space: ");
        token1 = scan.next();
        token2 = scan.next();
        System.out.println(token1 + "  " + token2);

        System.out.print("\nEnter two strings separated by a space: ");
        token1 = scan.next();
        token2 = scan.next();
        System.out.println(token1 + "  " + token2);
*****/

        /*------------------*/
        /* Part 4 - nextInt */
        /*------------------*/

        // read two integers from one line 

        int num1, num2;


    }
}


