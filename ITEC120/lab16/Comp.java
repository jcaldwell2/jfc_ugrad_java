/**
 * Comp.java
 *
 * Deep and shallow copy and comparison.
 * Comparing objects using equals() and compareTo().
 *
 * @author  Jeff Pittges
 * @version March 21, 2011
 */
import java.util.Scanner;

public class Comp
{
    public static void main(String[] args)
    {
        // Simple comparisons with strings
        String s1 = "Hello";
        String s2 = s1;

        System.out.println("s1 == s2       " + (s1 == s2));
        System.out.println("s1.equals(s2)  " + (s1.equals(s2)));
        System.out.println();

        s2 = "Hel";
        s2 += "lo";
        System.out.println("s1 == s2       " + (s1 == s2));
        System.out.println("s1.equals(s2)  " + (s1.equals(s2)));
        System.out.println();

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string:        ");
        String str1 = scan.next();

        System.out.print("Enter a second string: ");
        String str2 = scan.next();

        System.out.println();

        System.out.println("str1 == str2       " + (str1 == str2));
        System.out.println("str1.equals(str2)  " + (str1.equals(str2)));

        System.out.print("\nComparing the two strings: ");
        int diff = str1.compareTo(str2);

        if (0 == diff)
           System.out.println("str1 == str2");
        else if (diff > 0)
           System.out.println("str1 > str2");
        else
           System.out.println("str1 < str2");

    }
}


