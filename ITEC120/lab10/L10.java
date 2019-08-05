/**
*
*	L10 - Random Class and arrays to create histogram for 100 number from 0 - 9
*
*
*	@author James Caldwell 
*	@version October 1, 2014
*
*
*
*
*
*/



import java.util.Random;


public class L10
{


	public int generateNumbers(int total)
	{

	  
		final int UPPER_BOUND = 10;
		Random randObj = new Random();
		int number ;
		int totalSum = 0;
		int count0 = 0,count1 = 0,count2 = 0,count3 = 0,count4 = 0,count5 = 0,count6 = 0,count7 = 0,count8 = 0,count9 = 0;
		
		for( int i = 0; i < total; ++i)
		{
			number = randObj.nextInt(UPPER_BOUND);
			System.out.println("The number is:" + number);
			
			switch (number)
				{
				case 9:
					count9 += 1;
					break;
				case 8:
					count8 += 1;
					break;
				case 7:
					count7 += 1;
					break;
				case 6:
					count6 += 1;
					break;
				case 5:
					count5 += 1;
					break;
				case 4:
					count4 += 1;
					break;
				case 3:
					count3 += 1;
					break;
				case 2:
					count2 += 1;
					break;
				case 1:
					count1 += 1;
					break;
				case 0:
					count0 += 1;
					break;
				default:
					System.out.println("Something broke");
				}





            totalSum = count0 + count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9;


	
}
        System.out.println(this.print(0,count0));
        System.out.println(this.print(1,count1));
        System.out.println(this.print(2,count2));
        System.out.println(this.print(3,count3));
        System.out.println(this.print(4,count4));
        System.out.println(this.print(5,count5));
        System.out.println(this.print(6,count6));
        System.out.println(this.print(7,count7));
        System.out.println(this.print(8,count8));
        System.out.println(this.print(9,count9));
        System.out.println("\n");



				return totalSum;


}




      public static int print(int num, int count)
     {

           final String S = "***************************************************************************";
                  System.out.println(num +" :" + S.substring(0,count));

              return count;









        }
}
