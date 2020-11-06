package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Game game = (Game) object;
        return id == game.id &&
                java.util.Objects.equals(host, game.host) &&
                java.util.Objects.equals(guest, game.guest) &&
                java.util.Objects.equals(gameInformation, game.gameInformation) &&
                java.util.Objects.equals(guestsRoster, game.guestsRoster) &&
                java.util.Objects.equals(homeRoster, game.homeRoster) &&
                java.util.Objects.equals(goals, game.goals) &&
                java.util.Objects.equals(penalties, game.penalties);
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
