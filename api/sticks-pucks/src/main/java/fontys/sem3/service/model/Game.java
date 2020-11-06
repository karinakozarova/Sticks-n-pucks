package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Game {
    private int id;
    private Team host;
    private Team guest;

    private GameInformation gameInformation;

    private List<Player> guestsRoster;
    private List<Player> homeRoster;

    private List<Goal> goals;
    private List<Penalty> penalties;

    /**
     * Constructor
     */
    public Game(int id, Team host, Team guest, GameInformation gameInformation, List<Player> guestsRoster, List<Player> homeRoster) {
        this.id = id;

        this.host = host;
        this.guest = guest;

        this.gameInformation = gameInformation;

        this.guestsRoster = guestsRoster;
        this.homeRoster = homeRoster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Player> getGuestsRoster() {
        return guestsRoster;
    }

    public void setGuestsRoster(List<Player> guestsRoster) {
        this.guestsRoster = guestsRoster;
    }

    public List<Player> getHomeRoster() {
        return homeRoster;
    }

    public void setHomeRoster(List<Player> homeRoster) {
        this.homeRoster = homeRoster;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Penalty> getPenalties() {
        return penalties;
    }

    public void setPenalties(List<Penalty> penalties) {
        this.penalties = penalties;
    }

    public Team getHost() {
        return host;
    }

    public void setHost(Team host) {
        this.host = host;
    }

    public Team getGuest() {
        return guest;
    }

    public void setGuest(Team guest) {
        this.guest = guest;
    }

    public GameInformation getGameInformation() {
        return gameInformation;
    }

    public void setGameInformation(GameInformation gameInformation) {
        this.gameInformation = gameInformation;
    }

    public boolean teamPlays(String teamName) {
        return host.getName().equals(teamName) || guest.getName().equals(teamName);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Game{" +
                "id=" + id +
                ", host=" + host +
                ", guest=" + guest +
                ", gameInformation=" + gameInformation +
                ", guestsRoster=" + guestsRoster +
                ", homeRoster=" + homeRoster +
                ", goals=" + goals +
                ", penalties=" + penalties +
                '}';
    }
}
