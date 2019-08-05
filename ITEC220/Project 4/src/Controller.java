
/**
 * Controller uses methods to interact with the
 * PlayerStats class to retrieve data
 *
 * @author James Calwell
 * @version 4/13/2015
 */
import main.java.riotapi.RiotApiException;
import org.json.JSONException;
import org.json.JSONObject;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;


/**
 * The type Controller.
 */
public class Controller {

    private PlayerStats playerStats;
    private String playerName;
    private JSONObject player;
    private String playerId;
    private String avatarId;
    private String apiKey = "RGAPI-9f87342e-ae32-4335-90c7-a78a5a36e804";


    /**
     * Instantiates a new Controller.
     *
     * @param _playerName the _ player name
     * @throws IOException the iO exception
     * @throws JSONException the jSON exception
     * @throws RiotApiException the riot api exception
     */
    public Controller(String _playerName) throws IOException, JSONException,RiotApiException {

        playerName = _playerName;



        player = readJsonFromUrl("https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/" + playerName +
                "?api_key=" + apiKey);

        playerId = player.getJSONObject(playerName).getString("id");
        avatarId = player.getJSONObject(playerName).getString("profileIconId");
        playerStats = new PlayerStats(playerName,playerId,avatarId);


    }

    /**
     * Start void.
     *
     * @throws IOException the iO exception
     * @throws JSONException the jSON exception
     */
    public static void start() throws IOException, JSONException {

        MainWindow dialog = new MainWindow();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);

    }


    /**
     * Get match history.
     *
     * @return the string
     */
    public String getMatchHistory(){
        return playerStats.getMatchHistory();
    }

    /**
     * Get player stats.
     *
     * @return the string
     */
    public String getPlayerStats(){
        return playerStats.getPlayerStats();
    }

    /**
     * Gets player name.
     *
     * @return the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Gets player id.
     *
     * @return the player id
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     * Get icon.
     *
     * @return the buffered image
     */
    public BufferedImage getIcon(){

        return playerStats.getImage();
    }

    public long getPlayerLevel(){

        return playerStats.getPlayerLevel();
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
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
