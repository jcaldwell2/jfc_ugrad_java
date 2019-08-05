/**
*	StoryDriver - Used to make a fun story from user inputs
*
*	@author James Caldwell     
*	@version September 14, 2014
*
*
*/ 

import java.util.Scanner;

public class StoryDriver
{

	public static void main(String[] args)
	{
	
	
	Scanner getInput = new Scanner(System.in);
	
	System.out.println("Please tell me a made-up name");
		String madeUpName = getInput.nextLine();       
	System.out.println("Please tell me a color");
		String color1 = getInput.nextLine();    
	System.out.println("Now tell me a different color");
		String color2 = getInput.nextLine();    
	System.out.println("How about a body part(plural)");
		String bodyPart1 = getInput.nextLine();    
	System.out.println("Next we need a different body part(plural)");
		String bodyPart2 = getInput.nextLine();    
	System.out.println("Please tell me a singular noun");
		String singularNoun = getInput.nextLine();    
	System.out.println("Please tell me a present tense verb");
		String presTenseVerb = getInput.nextLine();    
	System.out.println("Please tell me a plural noun");
		String pluralNoun1 = getInput.nextLine();    
	System.out.println("Please tell me a large number");
		String number1 = getInput.nextLine();    
	System.out.println("Now we need a  different large number");
		String number2 = getInput.nextLine();    	
	System.out.println("Looking for a country on this one");
		String country1 = getInput.nextLine();    
	System.out.println("Now tell me a different country");
		String country2 = getInput.nextLine();    
	System.out.println("Please tell me a food(plural)");
		String food = getInput.nextLine();    
	System.out.println("Please tell me a plural noun");
		String pluralNoun2 = getInput.nextLine();    
	System.out.println("Next tell me your favorite song");
		String favSong = getInput.nextLine();    
	System.out.println("Now finally an adjective and we're done I promise");
		String adjective = getInput.nextLine();    
		
	Story story = new Story();
	
	String finalStory = story.storyInput(madeUpName,  color1,  color2,  bodyPart1,  bodyPart2,  singularNoun,  presTenseVerb,  pluralNoun1,  number1, number2,  country1,  country2,  food,  pluralNoun2,  favSong,  adjective);
	
	System.out.println("\nAn Odd Animal\n");
	System.out.println(finalStory);




	}
}