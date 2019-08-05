/**
 *PerimeterDriver.java
 *@Authors James Caldwell and Lance Price
 *@version September-10-2014
 */
 
 import java.util.Scanner;
 
 public class PerimeterDriver 
 {
 	public static void main(String[] args)
 	{
 		Scanner scan = new Scanner(System.in);
 		
//////////////////////////////////////////////////////////////////////////// 		
 		
 	   System.out.print("Enter a Value for Width : ");
   	   int width = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Height : ");
   	   int height = scan.nextInt();
   	   
///////////////////////////////////////////////////////////////////////////   	   
   	   
   	   Geometry geomObj = new Geometry();
   	   
   	   int recPerim = geomObj.perimeter(height, width);
   	   System.out.println("The Perimeter of a rectangle with height " +
   	   	   height + " and width " + width + "  is  " + recPerim);
 	}
 }