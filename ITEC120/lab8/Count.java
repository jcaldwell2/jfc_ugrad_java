/**
*	Count
*	@author James Caldwell
*	@version 9/17/2014
*
*
*
*/

import java.util.Scanner;


public class Count 

{
	
	public int countUp(int start,int stop)
	
	{
		if (start > stop) {
			start = stop;
			stop = start;
		}
			while (start < stop){
				System.out.println(" " + start);
				++start;
				
			}
		return start;
		
		
	}
	
	
}
	