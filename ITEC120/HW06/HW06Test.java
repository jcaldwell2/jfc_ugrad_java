/**
 *  HW06Test - Test Class with Sum, Range, Average, and Palindrome of a string.
 *  Testing various test cases of the metohds of HW06
 *
 *  @author James Caldwell
 *  @version October 5, 2014
 *
 *
 *
 *
 *
 *
 */



public class HW06Test
{

    public static void main(String[] args){

        //Test the sum method first with 3 test cases
        // Seems like changing elements in an array is actually time consuming
        // and not easy like testArray1[] = {5,2,3]; so I created multiple arrays
        int testArray1[]=  {};
        int testArray2[]= {5};
        int testArray3[]= {3,10};
        int testArray4[]= {3,5,10,20,36,50};

        HW06 hw06 = new HW06();

        System.out.println("Test the sum method.");
        System.out.println(hw06.sum(testArray1));
        System.out.println(hw06.sum(testArray2));
        System.out.println(hw06.sum(testArray3));
        System.out.println(hw06.sum(testArray4));
        System.out.println();
        // Test the range method

        int testArray5[]= {3,4,5};
        int testArray6[]= {5,4,3};
        int testArray7[]= {4,5,3};
        int testArray8[]= {3,5,10,20,36,50};

        System.out.println("Test the range method.");
        System.out.println();
        System.out.println(hw06.range(testArray5));
        System.out.println(hw06.range(testArray6));
        System.out.println(hw06.range(testArray7));
        System.out.println(hw06.range(testArray8));

        //Test the average method



        int testArray9[]= {2,4};
        int testArray10[]= {2,5};
        int testArray11[]= {3,5,10,20,36,50};

        System.out.println("Test the average method.");
        System.out.println();
        System.out.println(hw06.average(testArray9));
        System.out.println(hw06.average(testArray10));
        System.out.println(hw06.average(testArray11));


        char testArray12[]= {'A','B','B','A'};
        System.out.println();
        System.out.println("Test the palindrome method.");
        System.out.println();
        System.out.println(hw06.palindrome(testArray12));




















    }



















}