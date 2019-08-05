import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Scanner;


/**
 * Created by James on 4/27/2015.
 */
public class Controller {

    private Model model;
    private String address;
    private String code;
    private final String userName = "caldwejf";

    public Controller(){


        model = new Model();
    }




    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();

        int cp;
        while ((cp = rd.read()) != -1) {
           // System.out.println((char) cp);
            sb.append((char) cp);
        }
        return sb.toString();

    }



    public void getCodes() throws java.lang.Exception,IOException{

        DecimalFormat df = new DecimalFormat("#.00");
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNext()) {

            code = scan.next();
            address = "http://api.geonames.org/weatherIcaoJSON?ICAO=" + code + "&formatted=true&username=" + userName;

            JSONObject json = readJsonFromUrl(address);

            if (json.has("status")) {
                System.out.println(json);
            } else if(json.has("humidity")){

                model.addICAO(new ICAO(json.getJSONObject("weatherObservation").getString("stationName"),
                        json.getJSONObject("weatherObservation").getString("temperature"),
                        json.getJSONObject("weatherObservation").getDouble("lat"),
                        json.getJSONObject("weatherObservation").getDouble("lng"),
                        json.getJSONObject("weatherObservation").getString("datetime"),
                        json.getJSONObject("weatherObservation").getString("humidity"),
                        json.getJSONObject("weatherObservation").getString("clouds") ));


            }else{
                model.addICAO(new ICAO(json.getJSONObject("weatherObservation").getString("stationName"),
                        (json.getJSONObject("weatherObservation").getString("temperature")),
                        json.getJSONObject("weatherObservation").getDouble("lat"),
                        json.getJSONObject("weatherObservation").getDouble("lng"),
                        json.getJSONObject("weatherObservation").getString("datetime"),
                        "no humidity  listed",
                        json.getJSONObject("weatherObservation").getString("clouds")
                ));


            }
        }

        model.writeFile();

    }




    /**
     * Read json from url.
     *
     * @param url the url
     * @return the jSON object
     * @throws IOException the iO exception
     * @throws JSONException the jSON exception
     */
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }catch (IOException e){

            System.out.println("IOException occurred");

        }catch (JSONException e){

            System.out.println("JSON exception occurred");
        }
        return null;
    }
}
