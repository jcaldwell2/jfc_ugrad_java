import java.lang.String;

/**
 *  HW06 - Method Class with Sum, Range, Average, and Palindrome of a string
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

public class HW06 {


    public int sum(int array[]) {

        int total = 0;

        for(int i = 0;i < array.length;++i){
            total += array[i];
        }


        return total;

    }


    public int range(int array[]) {

        int total = 0;
        int high = array[0];
        int low = array[0];
            for(int i = 0;i < array.length;++i){
                if (array[i] > high)
                    high = array[i];
                if (array[i] < low)
                    low = array[i];

        }

        total = high - low;
        return total;

    }





    public double average(int array[]) {

        double avg = 0.0;
        double diff = 0.0;
        for(int i = 0;i < array.length;++i)
            diff += array[i];
        avg = diff /  array.length;


    return avg;

    }



    public boolean palindrome(char array[]) {

//        char[] test = {};
//        for(int i = array.length - 1 ;i > 0;--i)
//            test[i] = array[i];
//        if (test != array)
//            return false;

        // Keep getting a Arrayindexout of bounds exception when I run the palindrome method
        // wanted to go backwards from the highest index and create a new arrat based on that
        // and compare the two are equal


        return true;


    }




























}