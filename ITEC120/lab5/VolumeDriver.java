/**
 *VolumeDriver.java
 *@Authors James Caldwell and Lance Price
 *@version September-10-2014
 */
 
 import java.util.Scanner;
 
 public class VolumeDriver
 {
 	public static void main(String[] args)
 	{
 	   Scanner scan = new Scanner(System.in);
 	   
//////////////////////////////////////////////////////////////////// 	   
 		
 	   System.out.print("Enter a Value for Width : ");
   	   int width = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Height : ");
   	   int height = scan.nextInt();
   	   
   	   System.out.print("Enter a Value for Length : ");
   	   int length = scan.nextInt();
   	   
/////////////////////////////////////////////////////////////////////   	   
   	   
   	   
   	   Geometry geomObj = new Geometry();
   	   
   	   int recVol = geomObj.volume(length, width, height);
   	   System.out.println("The Volume of a rectangle with length " +
   	   	   length + " and width " + width + " and height " + height +
   	   	   	"  is  " + recVol);
   	   
   	   
   	   
   	   
   	   
 	}
 	
 }