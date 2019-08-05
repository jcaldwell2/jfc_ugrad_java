/**
 *Geometry.java - contains Geometry methods
 *@Author Lance Price and James Caldwell
 *@Version September-10-2014
 */
 
 public class Geometry
 {
 
 	 int height;
 	 int width;
 	 int length;
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
 	 
 	 public int area(int height, int width)
 	 {
 	 	 return height * width;
 	 }
 	 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int perimeter(int height, int width)
	{
		return 2 * (height + width);
	}
 	 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
 	 	 
 	public int volume(int height, int width, int length)
 	{
 		return length * width * height;
 	}
 	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////	


	public double density(int mass, int length, int height, int width)
	{
		double volume = this.volume(length, height, width);
		return mass / volume;
	}



} 		
