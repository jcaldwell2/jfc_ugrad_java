/**
 * L12ForEach - for each loop and methods class for searching arrays. 
 *             
 *
 * @author  James Caldwell 
 * @version 10-08-2014
 */ 

public class L12ForEach 
{

 
    public int range (int nums[])
    {

        if (nums.length == 0)
            return 0; 

        int total = 0;
        int high = nums[0];
        int low = nums[0];

        for(int i : nums){
            if (nums[i] > high)
                high = nums[i];
            if (nums[i] < low)
                low = nums[i];

        }

        total = high - low;

      
        return total;

    }
    public boolean isFound (int nums[], int val)
    {
        for(int i : nums)
        if (val == nums[i])
        return true;
      
      
        return false;
    }

    public int timesFound(int nums[],int val)
    {

        int found = 0;
        for(int i : nums)
        if (val == nums[i])
        ++found;

        return found;   
    }

 
 
    public int[] reverse(int nums[])
    { 
     
       int[] revArray = new int[nums.length];
    for(int i : nums) {
        revArray[i] = nums[nums.length - 1 - i];
    }
    return revArray;

 
    }
}