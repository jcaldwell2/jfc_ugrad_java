/**
 * L12DoWhile - do while loops and  methods class for searching arrays. 
 *             
 *
 * @author  James Caldwell 
 * @version 10-08-2014
 */ 

public class L12DoWhile 
{

 
    public int range (int nums[])
    {

        if (nums.length == 0)
            return 0; 

        int total = 0;
        int high = nums[0];
        int low = nums[0];
        int i = 0;
        do{
            if (nums[i] > high)
                high = nums[i];
            if (nums[i] < low)
                low = nums[i];
                ++i;
            } while (i < nums.length);
        

        total = high - low;

      
        return total;

    }
    public boolean isFound (int nums[], int val)
    {
        int i = 0;
        do{
        if (val == nums[i])
        return true;
        i++;
    }while (i < nums.length);
        return false;
    }

    public int timesFound(int nums[],int val)
    {

        int found = 0;
        int i = 0;
        do{
        if (val == nums[i])
        ++found;
        i++;
    }while (i < nums.length);
        return found;   
    }

 
 
    public int[] reverse(int nums[])
    { 
     
       int[] revArray = new int[nums.length];
    int i = 0;
        do {
        revArray[i] = nums[nums.length - 1 - i];
        i++;
    }while (i < nums.length);
    return revArray;

 
    }
}