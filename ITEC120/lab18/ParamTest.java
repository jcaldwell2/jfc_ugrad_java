/**
 * ParamTest.java -- test driver to learn about passing parameters.
 *
 * @author  Jeff Pittges 
 * @version February 2012 
 */
public class ParamTest
{
	public static void main(String[] args)
	{
	int num1 = 2, num2 = 3, num3 = 4;
	int sum = 0; 
	int[] nums = {21, 23};
	double avg = 0.0; 
	
	Param param = new Param();

	System.out.println("Initial values");
	System.out.println("sum: " + sum + "\tavg: " + avg + "\tnums[0]: " + nums[0] + "\tnums[1]: " + nums[1]);
	param.passIt(num1, num2, num3, sum, avg, nums);
	System.out.println("\nFinal values");
	System.out.println("sum: " + sum + "\tavg: " + avg + "\tnums[0]: " + nums[0] + "\tnums[1]: " + nums[1]);
	System.out.println(); 
	}
}
