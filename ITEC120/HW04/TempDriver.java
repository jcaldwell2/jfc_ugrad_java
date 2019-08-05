/**
*	TempDriver
*	
*	@author James Caldwell	
*	@version September 17,2014
*
*
*/ 


import java.util.Scanner;
import java.text.DecimalFormat; // used this from page 136 of the book because 
//format for one method would go to one decimal and the 
//other method had around 10 decimal places. Don't  know why either.



public class TempDriver

{
public static void main (String [] args)
{
	TempConverter temp = new TempConverter();
	Scanner scan = new Scanner(System.in);
	
	int menuNum = 100;
	double tempInput = 0.0;
	
	
	while (menuNum != 0){
		
	System.out.println("Please choose a menu option\n");
	System.out.println("0: Quit");
	System.out.println("1: Convert from Farenheit to Celsius");
	System.out.println("2: Convert from Celsius to Farenheit");
	
	menuNum = scan.nextInt();
	DecimalFormat fmt = new DecimalFormat("0.#"); // used from page 136 of the book to get correct formatting from both methods
	if (menuNum  == 1) {
		
		System.out.println("Please enter a temperature in Farenheit.\n");
		tempInput = scan.nextDouble();
		System.out.println(tempInput);
		double newTemp = temp.farenheit2Celsius(tempInput);
		System.out.println("Temperature is " + fmt.format(newTemp) + " degrees Celsius");
	}
	if (menuNum  == 2) {
		System.out.println("Please enter a temperature in Celsius.\n");
		tempInput = scan.nextDouble();
		System.out.println(tempInput);
		double newTemp = temp.celsius2Farenheit(tempInput);
		System.out.println("Temperature is " + fmt.format(newTemp) + " degrees Farenheit");
	}
		
		if (menuNum  != 0 && menuNum != 1 && menuNum != 2 ) {
		System.out.println("Sorry, that is an invalid selection.\n");
		
		
		
	}
	
	
	
	
	
	
	
	
}
	}
	
}

