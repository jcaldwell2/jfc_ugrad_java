/*******************************************************************************
Beer.java

@author Vito Antonacci
@version 22-JAN-2015

*******************************************************************************/

public class Beer
{ 
public static final String BEER = "Corona"; 
public static final String FRUIT = "limes";
public static final String STORE = "Mike’s" ;
public static final String CUSTOMER = "Jim"; 
public static final double DISCOUNT = .25;
public static final int INCREASE = 1;



	public static void main(String[] args)
	{
	

double fruitPrice = .40;
int beerPrice = 8;
double sale;
double total = 0.00;


System.out.println (STORE+ " Beer Cave sells a six-pack of "+BEER+" for $"+ beerPrice +  " and limes are "+fruitPrice+" cents each. "+CUSTOMER+" bought two six-packs of "+BEER+" and two "+FRUIT+" for $"+(total+=(sale=beerPrice * 2 + fruitPrice * 2))+". Last weekend "+BEER+" was "+(int)(DISCOUNT *100)+"% off. "+CUSTOMER+" bought three six-packs of "+BEER+" and four "+FRUIT+" for $"+(total+=sale=beerPrice * 3 + fruitPrice * 4)+". This week "+STORE+" raised the price of "+BEER+" by $"+INCREASE+". "+CUSTOMER+" bought one six-pack of "+BEER+" and two "+FRUIT+" for $"+(total+= sale=beerPrice * 1 + fruitPrice * 2)+". "+CUSTOMER+" has spent $"+total+" at "+STORE+"."); 

	}
}

