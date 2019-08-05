/**
 * GeomTest.java - testing some  geometry methods
 *
 * @author  James Caldwell Lance Price
 * @version September 9/10/14
 */
 
 import java.util.Scanner;

public class GeomTest
{

   public static void main(String[] args)
   {
   	   Scanner scan = new Scanner(System.in);
   	   
   	   System.out.print("Enter a Value for Width : ");
   	   int width = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Height : ");
   	   int height = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Length : ");
   	   int length = scan.nextInt();
   	   
////////////////////////////////////////////////////////////////////////////////   	      	      	      	   
   	      	       
   	   Geometry geomObj = new Geometry();
   	   
   	   int recArea = geomObj.area(height, width);
   	   System.out.println("The area of a rectangle with height " +
   	   	   height + " and width " + width + "  is  " + recArea);   	      	   
   	        
   }
}
