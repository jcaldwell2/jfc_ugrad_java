/**
*	CountTest
*	@author James Caldwell
*	@version 9/17/2014
*
*
*
*/

import java.util.Scanner;

public class CountTest 

{
	public void main(String[]args)
	
	{
	Scanner scan = new Scanner(System.in);
	Count count = new countUp();
	int num1 = 0;
	int num2 = 0;
	System.out.println("Please enter two numbers");
	
	num1 = scan.nextInt;
	num2 = scan.nextInt;
	int total = 0;
	
	total = Count.countUp(num1,num2);       
	System.out.println(total);
	
	
	
	
	
	
	}
}