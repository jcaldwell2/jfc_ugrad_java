/**
*	Loop
*	@author James Caldwell
*	@version 9/17/2014
*
*
*
*/

import java.util.Scanner;

public class Loop

{
	public static void main(String[]args)
	
	{
		
		int loop = 1;
		int maxNum = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a max number to count to from 1: ");
		maxNum = scan.nextInt();     
		while (loop <= maxNum)
		{ 
		
			
			
		
		System.out.print(" "+loop);
		++loop;
		;
			}
		
		int start = 0;
		int stop = 0;
		int start2 = 0;
		int stop2 = 0;
		System.out.println("\nEnter a start number and a stop number: ");
		start2 = scan.nextInt(); 
		stop2 = scan.nextInt(); 
		  
		
		
		if (start2 > stop2){
			start = stop2; 
			stop = start2;
		}
			else {
			start = start2;
			stop = stop2;
		}
		
		
		
		while (start <= stop)
		
			
		{ 
		
		
		System.out.print(" "+start);
		++start;
		;
			}
		        
		
		
		
		
		
		
		
		
		
	}
	
}
