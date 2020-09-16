package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Game {
    private int id;
    private Team host;
    private Team guest;
    private LocalDateTime start;
    private LocalDateTime end;
    private String rinkLocation; // the address of the ice rink used for home games

    private List<Player> guestsRoster;
    private List<Player> homeRoster;

    private List<Goal> goals;
    private List<Penalty> penalties;

    public Game(int id, Team host, Team guest, LocalDateTime start, LocalDateTime end, String rinkLocation, List<Player> guestsRoster, List<Player> homeRoster) {
        this.id = id;
        this.host = host;
        this.guest = guest;
        this.start = start;
        this.end = end;
        this.rinkLocation = rinkLocation;
        this.guestsRoster = guestsRoster;
        this.homeRoster = homeRoster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getRinkLocation() {
        return rinkLocation;
    }

    public void setRinkLocation(String rinkLocation) {
        this.rinkLocation = rinkLocation;
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

    public boolean teamPlays(String teamName){
        return host.getName().equals(teamName) || guest.getName().equals(teamName);
    }
}
