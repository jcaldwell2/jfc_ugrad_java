/**
 * L12While - while loop and  methods class for searching arrays. 
 *             
 *
 * @author  James Caldwell 
 * @version 10-08-2014
 */ 

public class L12While 
{

 
    public int range (int nums[])
    {

        if (nums.length == 0)
            return 0; 

        int total = 0;
        int high = nums[0];
        int low = nums[0];
        int i = 0;
        while (i < nums.length){
            if (nums[i] > high)
                high = nums[i];
            if (nums[i] < low)
                low = nums[i];
                ++i;
        }

        total = high - low;

      
        return total;

    }
    public boolean isFound (int nums[], int val)
    {
        int i = 0;
        while (i < nums.length){
        if (val == nums[i])
        return true;
        i++;
    }
        return false;
    }

    public int timesFound(int nums[],int val)
    {

        int found = 0;
        int i = 0;
        while (i < nums.length){
        if (val == nums[i])
        ++found;
        i++;
    }
        return found;   
    }

 
 
    public int[] reverse(int nums[])
    { 
     
       int[] revArray = new int[nums.length];
    int i = 0;
        while (i < nums.length) {
        revArray[i] = nums[nums.length - 1 - i];
        i++;
    }
    return revArray;

 
    }
}