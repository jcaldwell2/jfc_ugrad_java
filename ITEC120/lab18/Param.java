/**
 * Param.java -- method called by ParamTest to learn about passing parameters.
 *
 * @author  Jeff Pittges
 * @version February 2012 
 */
public class Param
{
	public void passIt(int n1, int n2, int n3, int sum, double avg, int[] a)
	{
		// print the incoming values 
		System.out.println("\nIncoming values");
		//System.out.print("n1: " + n1 + "\tn2: " + n2 + "\tn3: " + n3);
		System.out.print("sum: " + sum + "\tavg: " + avg);
		System.out.println("\ta[0]: " + a[0] + "\ta[1]: " + a[1]);
		
		sum = n1 + n2 + n3;
		avg = sum / 3;
		
		a[0] = 54;
		a[1] = 33;
		
		System.out.println("\nAfter value assignments");
		//System.out.print("n1: " + n1 + "\tn2: " + n2 + "\tn3: " + n3);
		System.out.print("sum: " + sum + "\tavg: " + avg);
		System.out.println("\ta[0]: " + a[0] + "\ta[1]: " + a[1]);
		
		int[] b = {12, 15, 17}; 
		a = b; 
		
		System.out.println("\nAfter array assignment");
		//System.out.print("n1: " + n1 + "\tn2: " + n2 + "\tn3: " + n3);
		System.out.print("sum: " + sum + "\tavg: " + avg);
		System.out.println("\ta[0]: " + a[0] + "\ta[1]: " + a[1]);
	}
}

