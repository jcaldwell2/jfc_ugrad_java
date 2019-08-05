/**
 *DensityDriver.java
 *@authors James Caldwell and Lance Price
 *@version September-10-2014
 */
 
 import java.util.Scanner;
 
 public class DensityDriver
 {
 	public static void main(String[] args)
 	{
 	   Scanner scan = new Scanner(System.in);
 	   
//////////////////////////////////////////////////////////////// 	   
 		
 	   System.out.print("Enter a Value for Width : ");
   	   int width = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Height : ");
   	   int height = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Length : ");
   	   int length = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Mass : ");
   	   int mass = scan.nextInt();
   	   
   	   
////////////////////////////////////////////////////////////////   	   
   	   
   	   Geometry geomObj = new Geometry();
   	   
   	   double recDens = geomObj.density(mass, length, width, height);
   	   System.out.println("The Density of an Object with length " +
   	   	   length + " and width " + width + " and height " + height +
   	   	   " and mass " + mass + "  is  " + recDens);
   	   
   	   
   	   
   	   
 	}
 	
 }