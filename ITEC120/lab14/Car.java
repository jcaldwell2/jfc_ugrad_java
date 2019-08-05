
/**
 * Car - a class that creates Car objects 
 * 
 * @James Caldwell
 * @October 15,2014
 */
public class Car
{

    private String make;
    private String model;
    private int year;

    public Car(String _make, String _model, int _year)
    {
        this.make = _make;
        this.model = _model;
        this.year = _year;

    }

    public String toString()
    {
        return make + "-" + model + " " + "(" + year + ")";
    }

    public String getMake() 
    {

        return make;

    }

    public String getModel()    
    {

        return model;

    }

    public int getYear()    
    {

        return year;

    }
    
    
    public int setYear(int _year)
    {
        this.year = _year;
        
        return year;
    }
    
    public String setModel(String _model)
    {
        this.model = _model;
        
        return model;
    }
    
    public String setMake(String _make)
    {
        this.make = _make;
        
        return make;
    }
}
