/**
*	Conditionals - Class used to setup methods with conditionals
*	
*	@author James Caldwell	
*	@version September 17,2014
*
*
*/ 

public class Conditionals 	
{

	public char letterGrade(double numberGrade)
	
	{
		char letter;
		
		if ( numberGrade >= 90) {
			letter = 'A';
			return letter;
		}else if (numberGrade >= 80){
			letter = 'B';
			return letter;
			
		}else if (numberGrade >= 70){
				letter = 'C';
				return letter;
			}					
				else if (numberGrade >= 60){
						
					letter = 'D';
					return letter;}
					
					else {
					letter = 'F';
					return letter;	}
		
		
		
		
		}
		
		
		
		public String isLeapYear(int year) 
		
		{
			
		String leapYear = "";
		
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			leapYear = "True";
			return leapYear;
		}
			else {
				leapYear = "False";
				return leapYear;
		}                                          
			
			
			
		}
	}
	

