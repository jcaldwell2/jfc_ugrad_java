
/**
 * Class Box - Create a box object with 4 parameters, 3 of them int, 1 boolean
 * 
 * @author James Caldwell   
 * @version October 19, 2014
 */
public class Box
{
    
    private int height;
    private int width;
    private int depth;
    private boolean full;
    /**
     * Constructor for objects of class Box
     */
    public Box(int _height, int  _width, int _depth)
    {
      this.height = _height;
      this.width = _width;
      this.depth = _depth;
      
    }


    public void setHeight(int _height)
    {
        this.height = _height;
        
    }
        public void setWidth(int _width)
    {
        this.width = _width;
        
    }
        public void setDepth(int _depth)
    {
        this.depth = _depth;
        
    }
        public void setFull(boolean _full)
    {
        this.full = _full;
        
    }
    
    
     public int getHeight()
    {
        return this.height;
        
    }
        public int getWidth()
    {
        return this.width;
        
    }
        public int getDepth()
    {
       return this.depth;
        
    }
        public boolean getFull()
    {
        return this.full;
        
    }
    
    public String toString()
    
    {
        return height +"x" + width + "x" + depth;
        
        
        
    }
    
}



