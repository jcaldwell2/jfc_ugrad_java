/**
 * Playerstats is the model the contains all the data
 *
 * @author James Calwell
 * @version 4/13/2015
 */

import constant.*;
import dto.MatchHistory.*;
import dto.Stats.PlayerStatsSummary;
import dto.Stats.PlayerStatsSummaryList;
import dto.Summoner.Summoner;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * The type Player stats.
 */
public class PlayerStats  {

    private String playerID;
    private String playerName;
    private String avatarID = "";
    private String version = "5.7.2";
    private BufferedImage image;
    private JSONObject stats;
    private String apiKey = "2060fca3-5466-4830-b453-126d6c40049b";
    private String matchHistory = "";
    private String playerStats = "";
    private PlayerHistory history;
    private long playerLevel = 0;
    private  Summoner summoner;

    /**
     * Instantiates a new Player stats.
     *
     * @param _playerName the _ player name
     * @param _playerID the _ player iD
     * @param _avatarID the _ avatar iD
     * @throws IOException the iO exception
     * @throws JSONException the jSON exception
     * @throws RiotApiException the riot api exception
     */
    public PlayerStats(String _playerName, String _playerID, String _avatarID )throws IOException, JSONException, RiotApiException{

        playerName = _playerName;
        playerID = _playerID;
        avatarID = _avatarID;
        setImage();
        getHistory();
        getStats();
        getLevel();
    }

    /**
     * Set image.
     */
    public void setImage(){

      try {
          String path = "http://ddragon.leagueoflegends.com/cdn/" + version +
                  "/img/profileicon/" + avatarID +".png ";
          URL url = new URL(path);
          image = ImageIO.read(url);
      }catch(IOException e){
          System.out.println("IOException");

       }

   }

    /**
     * Gets history.
     *
     * @throws IOException the iO exception
     * @throws JSONException the jSON exception
     * @throws RiotApiException the riot api exception
     */
    public void getHistory()throws IOException, JSONException, RiotApiException {


        RiotApi api = new RiotApi(apiKey);
        api.setRegion(Region.NA);
        api.setSeason(Season.Season5);

        Map<String, Summoner> summoners = api.getSummonerByName(playerName);
        summoner = summoners.get(playerName);

        try {
            history = api.getMatchHistory(summoner.getId());
            List<MatchSummary> matches = history.getMatches();
            for (MatchSummary match : matches) {

                matchHistory += "----------Match------------------";
                matchHistory += "\nGame Mode: " + GameMode.valueOf(match.getMatchMode()).getName();
                matchHistory += "\nQueue: " + QueueType.valueOf(match.getQueueType()).getName();

                matchHistory += "\n----------Player----------------";
                Participant participant = match.getParticipants().get(0);
                Player player = match.getParticipantIdentities().get(0).getPlayer();
                matchHistory += "\nSummoner: " + player.getSummonerName();
                matchHistory += "\nChampion: " + api.getDataChampion(participant.getChampionId()).getName();


                matchHistory += "\n---------Match Stats-----------";
                ParticipantStats stats = participant.getStats();
                matchHistory += "\nLevel: " + stats.getChampLevel();
                matchHistory += "\nKills: " + stats.getKills();
                matchHistory += "\nDeaths: " + stats.getDeaths();
                matchHistory += "\nAssists: " + stats.getAssists();
                matchHistory += "\nDouble Kills: " + stats.getDoubleKills();
                matchHistory += "\nTriple Kills: " + stats.getTripleKills();
                matchHistory += "\nQuadra Kills: " + stats.getQuadraKills();
                matchHistory += "\nPenta Kills: " + stats.getPentaKills();
                matchHistory += "\nTotal Gold: " + stats.getGoldEarned();
                if (stats.isWinner())
                    matchHistory += "\nVICTORY";
                else
                    matchHistory += "\nDEFEAT";
                matchHistory += "\n-----------------------------------";
                matchHistory += "\n";
                matchHistory += "\n";
            }
        } catch (NullPointerException e) {

            matchHistory = "Sorry, no Ranked games played";

        }


    }

    public void getLevel(){

        playerLevel = summoner.getSummonerLevel();
    }

    public long getPlayerLevel(){

        return playerLevel;
    }


    /**
     * Gets stats from Riot API.
     *
     * @throws RiotApiException the riot api exception
     */
    public void getStats()throws RiotApiException{

        RiotApi api = new RiotApi(apiKey);
        api.setRegion(Region.NA);
        api.setSeason(Season.Season5);

        Map<String, Summoner> summoners = api.getSummonerByName(playerName);
        Summoner summoner = summoners.get(playerName);
        PlayerStatsSummaryList statsListDto = api.getPlayerStatsSummary(Region.NA, Season.FIVE, summoner.getId());
        List<PlayerStatsSummary> summaries = statsListDto.getPlayerStatSummaries();

        for(PlayerStatsSummary statsSummary : summaries) {
            playerStats += "\n---------------------------------------";
            playerStats += "\n" + PlayerStatSummaryType.valueOf(statsSummary.getPlayerStatSummaryType());
            playerStats += "\nWins: " + statsSummary.getWins();
            playerStats += "\nLosses: " + statsSummary.getLosses();

        }
    }


    /**
     * Gets match history.
     *
     * @return the match history
     */
    public String getMatchHistory() {
        return matchHistory;
    }

    /**
     * Gets player stats.
     *
     * @return the player stats
     */
    public String getPlayerStats() {
        return playerStats;
    }


    /**
     * Gets image.
     *
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Gets avatar iD.
     *
     * @return the avatar iD
     */
    public String getAvatarID() {
        return avatarID;
    }

    /**
     * Sets avatar iD.
     *
     * @param avatarID the avatar iD
     */
    public void setAvatarID(String avatarID) {
        this.avatarID = avatarID;
    }


    /**
     * Gets player iD.
     *
     * @return the player iD
     */
    public String getPlayerID() {
        return playerID;
    }

    /**
     * Sets player iD.
     *
     * @param playerID the player iD
     */
    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }
}
