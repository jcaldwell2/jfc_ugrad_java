/**
*	Story - Used to take user inputs from StoryDriver and construct a string 
*	that holds a full story based off of An Odd Animal
*	@author James Caldwell     
*	@version September 14, 2014
*
*
*/ 

public class Story
{
	
	String madeUpName,  color1,  color2,  bodyPart1,  bodyPart2,  singularNoun,  presTenseVerb,  pluralNoun1,  number1, number2,  country1,  country2,  food,  pluralNoun2,  favSong,  adjective;
	
	
	public String storyInput(String madeUpName, String color1, String color2, String bodyPart1, String bodyPart2, String singularNoun, String presTenseVerb, String pluralNoun1, String number1, String number2, String country1, String country2, String food, String pluralNoun2, String favSong, String adjective)
		
	{	
		String storyTime = "The " + madeUpName + " is an animal that has " + color1 + " fur with " + color2 + " spots on its " + bodyPart1 + " and " + bodyPart2 + "." + " Its tail is shaped like a(n) " + singularNoun + " which it uses to " + presTenseVerb + " " + pluralNoun1 + ". " + "An adult " + madeUpName + " may weigh more than " + number1 + " pounds and stand over " + number2 + " feet high." + "\n\nThe " + madeUpName + " can be found only in " + country1 + " and " + country2 + ". Although its favorite food is " + food + ", it also likes to eat " + pluralNoun2 + ". If you ever see a(n) " + madeUpName + ", be sure not to ever sing \""+favSong+".\" That song makes it " + adjective + ". Instead, give it a few " + food + " and be on your way." ;
		
		return storyTime;
		
		
		
		
		
		
	}
}