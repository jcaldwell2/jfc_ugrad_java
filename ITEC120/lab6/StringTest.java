/**
 * StringTest - testing the String method
 *
 * @author  James Caldwell
 * @version September 09/12/2014
 */
 
public class StringTest
{

 public static void main (String[] args)
 {
 	
 // Testing an empty string, 1 character string, and multiple character string
 	

         System.out.println("length");

 	 int len = -1;

 	 String s = ""; // empty string

 	 len = s.length();

 	 System.out.println("\nexpected: 0 actual: " + len);

 	 s = "a";

 	 len = s.length();

 	 System.out.println("expected: 1 actual: " + len);

 	 s = "abcde";

 	 len = s.length();

 	 System.out.println("expected: 5 actual: " + len);
 	 
 	 
// charAt testing

	System.out.println("\nTesting the string \"abcde\"");

	System.out.println("pos 0: " + s.charAt(0));

	System.out.println("pos 1: " + s.charAt(1));

	System.out.println("pos 2: " + s.charAt(2));

	System.out.println("pos 3: " + s.charAt(3));

	System.out.println("pos 4: " + s.charAt(4));

	System.out.println("pos length - 1: "

		+ s.charAt(s.length() - 1));
 	 
// indexOf testing

	s = "abcde";

	System.out.println("\nTesting the string \"abcde\"");

	System.out.println("indexOf c: " + s.indexOf("c", 0));

	System.out.println("indexOf bc: " + s.indexOf("bc", 0));
 	 
// My own indexOf 

 	 
 	 String str1 = "I am Ironman";
 	 String str2 = "NoBlanksHere";
 	 
 	 
 	 System.out.println("\nString 1 is: " +  str1);
 	 
 	 System.out.println("\nString 2 is: " +  str2);
 	 
 	 System.out.println("\nThe first character I is at index: " + str1.indexOf("I", 0));
 	 
 	 System.out.println("The middle character I is at index: " + str1.indexOf("I", 3));
 	 
 	 System.out.println("The last character n is at index: " + str1.indexOf("n", 10));
 	 
 	 System.out.println("Let's test the whole string at index 0: " + str1.indexOf("I am Ironman", 0));
 	 
 	  System.out.println("Let's search string1 for a blank character: " + str1.indexOf("", 3)); 
 	  
 	  // after trying multiple indexes the search for a blank character returns an index of whatever fromindex is used
 	  
 	  System.out.println("Let's search string2 for a blank character: " + str2.indexOf("", 4));
 	                                                                  
 	 
 	 
 // equals method
 
 	String str3 = "";
 	String str4 = "A";
 	 
 	System.out.println("\n");
 	System.out.println(str3.equals(""));
 	System.out.println(str4.equals("A"));
 	System.out.println(str3.equals(str2));
 	System.out.println(str1.equals(str4));
 	System.out.println(str1.equals("I am Ironman"));
 	
 // compareTo method
 // this is just like what they have listed at the Java website on the compareTo method
 
 String s1 = "Roger wilco!";
 String s2 = "Roger wilco!";
 
 	System.out.println("\n");
 
 int result = s1.compareTo( s2 ) ; 
 	System.out.println(result);
 	
 	s1 = "Wii";
 	
 	result = s1.compareTo( s2 ) ; 
 	System.out.println(result);
 	
 	s1 = "Up, up, and awaaaaaaaaaaaay!";
 	
 	result = s2.compareTo( s1 ) ; 
 	System.out.println(result);
 	
 	System.out.println(s1);
 	System.out.println(s2);
 	
 	
 
 	 
 }
 
}
