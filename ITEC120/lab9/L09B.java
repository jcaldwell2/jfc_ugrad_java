/**
 * L09B.java -- methods that operate on strings using For loops. 
 * 
 * @author  James Caldwell
 * @version 24-Sept-2014
 */
import java.util.Random;

public class L09B
{
	/**
	 * min() - returns the minimum character in the given string.
	 *
	 * @param str the string to be processed 
	 * @return the minimum character in the given string
	 */
	public char min(String str)
	{
		char low = '!';
		for(int count = 0;count<=str.length(); ++count){
		
		int result = str.charAt(count);
		
		System.out.println(result);
		
		low = result;
		}
			
		

		return low; 
	}

	/**
	 * max() - returns the maximum character in the given string.
	 *
	 * @param str the string to be processed 
	 * @return the maximum character in the given string
	 */
	public char max(String str)
	{
		char high = '!';

		return high; 
	}

	/**
	 * isFound() - answers if the given character is found in the given string
	 * 
	 * @param str the string to processed
	 * @param ch  the character to be found
	 * @return true if the character is found, false if not found.
	 */
	public boolean isFound(String str, char ch)
	{
		boolean found = false;
		
		return found; 
	}

	/**
	 * timesFound() - returns the number of times the given character 
	 *				  appears in the given string.
	 * 
	 * @param str the string to be processed
	 * @param ch  the character to be found
	 * @return the number of times the given character is found 
	 *		   in the given string. 
	 */
	public int timesFound(String str, char ch)
	{
		int total = 0;

		return total; 
	}

	/**
	 * isVowel() - answers if the given character is a vowel.
	 *
	 * @param ch the character to be processed
	 * @return answers if the given character is a vowel.
	 */
	public boolean isVowel(char ch)
	{
		return false;
	}

	/**
	 * numVowels() - returns the number of vowels in the given string.
	 *
	 * @param str the string to be processed
	 * @return the number of vowels in the given string. 
	 */
	public int numVowels(String str)
	{
		int total = 0; 

		return total; 
	}
}


