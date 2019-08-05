import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by James on 4/27/2015.
 */
public class ICAO {

    private String station;
    private String latitude;
    private String longitude;
    private String temperature;
    private String dateTime;
    private String humidity;
    private String cloud;

    public ICAO(String _station,String temp, double _lat, double _long, String _dateTime,String _humidity, String _clouds){
        NumberFormat df = new DecimalFormat("#0.00");
        this.station = _station;
        this.temperature = temp;
        this.latitude = df.format(_lat);
        this.longitude = df.format(_long);
        this.dateTime = _dateTime;
        this.humidity = _humidity;
        this.cloud = _clouds;




    }
    public double getTemp() {

        if (!temperature.isEmpty()) {
            double temp = Double.parseDouble(temperature);
            return temp;
        }

        return 0.0;
    }

    public String toString(){


        return station + " " + temperature + " " + latitude + " " + longitude + " " + dateTime +
                " " + humidity + " " + cloud;
    }





}
