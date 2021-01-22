package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Team {
    private int id;
    private String name;
    private String logoResourceLocation; // where the image is stored on our server
    private String rinkLocation; // the address of the ice rink used for home games
    private Player captain;
    private List<Player> assistants;
    private List<Player> players;
    private Manager manager;

    /**
     * Constructor
     */
    public Team(int id, String name, String logoResourceLocation, String rinkLocation) {
        this.id = id;
        this.name = name;
        this.logoResourceLocation = logoResourceLocation;
        this.rinkLocation = rinkLocation;
        this.assistants = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager){
        this.manager = manager;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public List<Player> getAssistants() {
        return assistants;
    }

    public List<Player> getLeadPlayers() {
        List<Player> leads = assistants;
        leads.add(captain);
        return leads;
    }

    public void setAssistants(List<Player> assistants) {
        this.assistants = assistants;
    }

    public void deleteAssistants() {
        this.assistants.clear();
    }

    public void addPlayerToRoster(Player player) {
        this.players.add(player);
    }

    public void addAssistant(Player player) {
        // add check - part of the team
        this.assistants.add(player);
    }

    public boolean removeAssistant(Player player) {
        if (this.assistants.contains(player)) {
            this.assistants.remove(player);
            return true;
        }
        return false;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Team team = (Team) object;
        return id == team.id &&
                java.util.Objects.equals(name, team.name) &&
                java.util.Objects.equals(logoResourceLocation, team.logoResourceLocation) &&
                java.util.Objects.equals(rinkLocation, team.rinkLocation);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, name, logoResourceLocation, rinkLocation);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoResourceLocation() {
        return logoResourceLocation;
    }

    public void setLogoResourceLocation(String logoResourceLocation) {
        this.logoResourceLocation = logoResourceLocation;
    }

    public String getRinkLocation() {
        return rinkLocation;
    }

    public void setRinkLocation(String rinkLocation) {
        this.rinkLocation = rinkLocation;
    }
}
