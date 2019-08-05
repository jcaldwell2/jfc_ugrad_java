/**
 *GeometryDriver.java
 *@Authors James Caldwell and Lance Price
 *@version September-10-2014
 */
 
 import java.util.Scanner;
 
 public class GeometryDriver
 {
 	public static void main(String[] args)
 	{
 		
 		Scanner scan = new Scanner(System.in);
 		
//////////////////////////////////////////////////////////////////////////////// 		
 		
 	   System.out.print("Enter a Value for Width of a Rectangle : ");
   	   int width = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Height of a Rectangle : ");
   	   int height = scan.nextInt();   	  
   	   		
///////////////////////////////////////////////////////////////////////////////// 		
 		
 	   Geometry geomObj = new Geometry();
   	   
   	   int recPerim = geomObj.perimeter(height, width);
   	   System.out.println("The Perimeter of a rectangle with height " +
   	   	   height + " and width " + width + "  is  " + recPerim);
   	   	   
   	   	   
   	   int recArea = geomObj.area(height, width);
   	   System.out.println("The area of a rectangle with height " +
   	   	   height + " and width " + width + "  is  " + recArea);   
 		
////////////////////////////////////////////////////////////////////////////////// 		
 		 				
 	   System.out.print("Enter a Value for Width of an Object : ");
   	   int width1 = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Height of an Object : ");
   	   int height1 = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Length of an Object : ");
   	   int length1 = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Mass of an Object : ");
   	   int mass1 = scan.nextInt();
   	   
///////////////////////////////////////////////////////////////////////////////////


	   int recVol = geomObj.volume(length1, width1, height1);
   	   System.out.println("The Volume of a rectangle with length " +
   	   	   length1 + " and width " + width1 + " and height " + height1 +
   	   	   	"  is  " + recVol);
   	   	   	
   	   	   	
   	   double recDens = geomObj.density(mass1, length1, width1, height1);
   	   System.out.println("The Density of an Object with length " +
   	   	   length1 + " and width " + width1 + " and height " + height1 +
   	   	   " and mass " + mass1 + "  is  " + recDens);   	   
   	   
 		
 		
 		
 		
 		
 		
 	}
 }