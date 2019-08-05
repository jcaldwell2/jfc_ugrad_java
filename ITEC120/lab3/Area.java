/**
 * Area.java - used to compute the area of a square
 *
 * @author  James Caldwell
 * @version September 03/2014
 */
 
 import java.util.Scanner;

public class Area
{

   public static void main(String[] args)
   {
    
     int lengthSide;     
     
      Scanner scan = new Scanner(System.in);

      System.out.print("Enter the length of the side of a square ");
      lengthSide = scan.nextInt();
      System.out.println("Length of the side is  " + lengthSide);
      
     int squareArea = lengthSide * lengthSide;
     
     System.out.println("Area of the square is   " + squareArea);
      
    
     int lengthHeight;
     
     
      System.out.println("Please enter a Length and then a Height." );
      lengthSide = scan.nextInt();
      lengthHeight = scan.nextInt();
      System.out.println("You have entered " + lengthSide + " for the length and " +
      	      lengthHeight + " for the height.");
      int perimeter = ((lengthSide * 2) + (lengthHeight * 2));
      int area = lengthSide * lengthHeight;
      System.out.println("The perimeter is " + perimeter + " and the area is " + area); 
   }
}
