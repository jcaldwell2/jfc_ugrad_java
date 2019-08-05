/**
 * L09Test.java -- test driver for the L09 class. 
 *
 * @author  Jeff Pittges
 * @version 14-Feb-2013
 */
import java.util.Random;

public class L09Test
{
	public static void main(String[] args)
	{
		final String PASS = "Pass";
		final String FAIL = "Fail";

		L09B lab9 = new L09B();
		
		int testNum = 1;
		String tst = "";	// test string 
		String result = FAIL;

		// ***
		// min
		// ***

		System.out.println("\nTesting min\n");

		// empty string 
		tst = "";
		char ch  = lab9.min(tst);
		result = (ch == '!') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// string of length 1
		tst = "m";
		ch  = lab9.min(tst);
		result = (ch == 'm') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// min in first position 
		tst = "abcdefg";
		ch  = lab9.min(tst);
		result = (ch == 'a') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// min in last position 
		tst = "zyxw";
		ch  = lab9.min(tst);
		result = (ch == 'w') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// min in middle position 
		tst = "zybafglqr";
		ch  = lab9.min(tst);
		result = (ch == 'a') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// min character repeated 
		tst = "zzz";
		ch  = lab9.min(tst);
		result = (ch == 'z') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// ***
		// max
		// ***

		testNum = 1; 
		System.out.println("\nTesting max\n");

		// empty string 
		tst = "";
		ch  = lab9.max(tst);
		result = (ch == '!') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// string of length 1
		tst = "m";
		ch  = lab9.max(tst);
		result = (ch == 'm') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// max in last position 
		tst = "abcdefg";
		ch  = lab9.max(tst);
		result = (ch == 'g') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// max in first position 
		tst = "zyxw";
		ch  = lab9.max(tst);
		result = (ch == 'z') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// max in middle position 
		tst = "aybzfglqr";
		ch  = lab9.max(tst);
		result = (ch == 'z') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// max character repeated 
		tst = "sss";
		ch  = lab9.max(tst);
		result = (ch == 's') ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// *******
		// isFound
		// *******

		testNum = 1; 
		System.out.println("\nTesting isFound\n");

		// empty string 
		tst = "";
		result = (!lab9.isFound(tst, 'x')) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// string of length 1 - found
		tst = "b";
		result = (lab9.isFound(tst, 'b')) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// string of length 1 - not found
		tst = "b";
		result = (!lab9.isFound(tst, 'e')) ? PASS : FAIL; 

		System.out.println(testNum + ": " + result);
		++testNum;

		// found at start of string 
		tst = "abcdef";
		result = (lab9.isFound(tst, 'a')) ? PASS : FAIL; 

		System.out.println(testNum + ": " + result);
		++testNum;

		// found in middle of string 
		tst = "abcdefg";
		result = (lab9.isFound(tst, 'd')) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// found at end of string 
		tst = "abcdef";
		result = (lab9.isFound(tst, 'f')) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// many characters -- not found 
		tst = "abcdef";
		result = (!lab9.isFound(tst, 'y')) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		// **********
		// timesFound
		// **********

		testNum = 1; 
		System.out.println("\nTesting timesFound\n");

		// string of length 0
		tst = "";
		int times = lab9.timesFound(tst, 'r');
		result = (times == 0) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum; 

		// length 1 - found 
		tst = "r";
		times = lab9.timesFound(tst, 'r');
		result = (times == 1) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum; 

		// length 1 - not found 
		tst = "q";
		times = lab9.timesFound(tst, 'r');
		result = (times == 0) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum; 

		// long string found
		tst = "qdqbflqrsqbtfvuq";
		times = lab9.timesFound(tst, 'q');
		result = (times == 5) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum; 

		// long string not found 
		tst = "qdqbflqrsqbtfvuq";
		times = lab9.timesFound(tst, 'c');
		result = (times == 0) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum; 


		// *******
		// isVowel 
		// *******

		testNum = 1; 
		System.out.println("\nTesting isVowel\n");

		result = (lab9.isVowel('a')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (lab9.isVowel('b')) ? FAIL : PASS;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (lab9.isVowel('e')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (lab9.isVowel('i')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (lab9.isVowel('o')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (lab9.isVowel('u')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (!lab9.isVowel('z')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (!lab9.isVowel('y')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (!lab9.isVowel('Z')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		result = (!lab9.isVowel('!')) ? PASS : FAIL;
		System.out.println(testNum + ": " + result);
		++testNum; 

		// *********
		// numVowels
		// *********

		System.out.println("\nTesting numVowels\n");
		testNum = 1; 

		tst = "";
		int vowelCount = lab9.numVowels(tst);
		result = (vowelCount == 0) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		tst = "abcdefghijklmnopqrstuvwxyz";
		vowelCount = lab9.numVowels(tst);
		result = (vowelCount == 5) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		tst = "xyzpdq";
		vowelCount = lab9.numVowels(tst);
		result = (vowelCount == 0) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;

		tst = "eoaaoeuieiua";
		vowelCount = lab9.numVowels(tst);
		result = (vowelCount == 12) ? PASS : FAIL;

		System.out.println(testNum + ": " + result);
		++testNum;
	}
}


