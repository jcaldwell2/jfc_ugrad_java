
/**
 * L19 - class methods using object arrays as params.
 * 
 * @author James Caldwell 
 * @version November 5th, 2014
 */
public class L19
{

    public Treasure min(Treasure[] treasure)
    {
        Treasure min = treasure[0];

        for(int i = 0; i < treasure.length; i++)
            if(treasure[i].getVal() < min.getVal())
                min = treasure[i];

        return min;
    }

    public Treasure max(Treasure[] treasure)
    {
        Treasure max = treasure[0];

        for(int i = 0; i < treasure.length; i++)
            if(treasure[i].getVal() > max.getVal())
                max = treasure[i];

        return max;
    }

    public boolean isFound(Treasure[] treasure, Treasure tObj)
    {
        boolean  yes = false;

        for(int i = 0; i < treasure.length; i++)

            if(treasure[i].equals(tObj))
                yes = true;

        return yes;
    }

    public int timesFound(Treasure[] treasure, Treasure tObj)
    {
        int found = 0;

        for(int i = 0; i < treasure.length; i++)

            if(treasure[i].equals(tObj))
                found++;

        return found;
    }

}
