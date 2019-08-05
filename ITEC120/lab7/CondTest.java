/**
*	CondTest - Test Driver for the conditionals method test of the 
*		Conditionals class
*	
*	@author James Caldwell	
*	@version September 17,2014
*
*
*/ 


import java.*;

public class CondTest
{

public static void main (String [] args)
{
	
	
	final String PASS = "Pass";

	final String FAIL = "Fail";

	int testNum = 1;

	char grade;

	String result = "";

	Conditionals condObj = new Conditionals();
	
	

	
	grade = condObj.letterGrade(95);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	
	grade = condObj.letterGrade(90);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(89.9);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(85);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(80);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(79);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(79.99);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(70);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(69.9);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(60);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(59.9);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(0);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(101);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	
	grade = condObj.letterGrade(-1);

	
	if (grade == 'A')

		result = PASS;

	else

		result = FAIL;

	System.out.println(testNum + ": " + result);

	++testNum;
	

		
		
		System.out.println(condObj.isLeapYear(2003));
		System.out.println(condObj.isLeapYear(2004));
		System.out.println(condObj.isLeapYear(1900));
		System.out.println(condObj.isLeapYear(2000));






}
}