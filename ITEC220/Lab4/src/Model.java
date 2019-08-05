import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by James on 4/27/2015.
 */
public class Model {

    private ArrayList<ICAO> collection;

    public Model(){

        collection = new ArrayList<ICAO>();
    }




    public void addICAO(ICAO icao){

        collection.add(icao);
    }
    public void printList(){

        for(ICAO icao: collection){

            System.out.println(icao);
        }
    }


    public void writeFile() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (ICAO icao : collection) {
                writer.write(icao.toString());
                writer.newLine();
            }
            writer.write("The average temperature is "+ avgTemp());
            writer.newLine();
            writer.write((maxMinTemp()));

            writer.close();
        } catch (IOException e) {
            System.out.println("IOException");

        }

    }

    public String avgTemp(){
        double temp = 0;
        int count = 0;
        double average;

        DecimalFormat df = new DecimalFormat("#.00");

        for(ICAO icao: collection){
            temp += icao.getTemp();
            count++;
        }

        average = (temp/count);
        return df.format(average);


    }
    public String maxMinTemp(){

        double temp;
        double lowTemp = 100.00;
        double highTemp = 0.00;
        DecimalFormat df = new DecimalFormat("#.00");

        for(ICAO icao: collection){

            temp = icao.getTemp();
            if(temp> highTemp)
                highTemp = temp;
            if(temp < lowTemp)
                lowTemp = temp;

        }
        df.format(lowTemp);
        df.format(highTemp);

        return "The highest temperature was "+highTemp+" and lowest temperature was "+lowTemp;


    }
}


