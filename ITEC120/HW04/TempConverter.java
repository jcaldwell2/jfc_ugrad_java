/**
*	TempConverter
*	
*	@author James Caldwell	
*	@version September 17,2014
*
*
*/ 




public class TempConverter


{
	public double celsius2Farenheit (double tempF)
	
	{
	
	double newTempF =(tempF) * (9.0/5.0) + 32.0;
	
	return newTempF;
	
	}
	
	public double farenheit2Celsius (double tempC)
	
	{
	
	double newTempC = (tempC - 32.0)* (5.0/9.0);
	
	return newTempC;
	
	}
	
	
	
	
	
	
	
	
}
