package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import java.time.LocalDateTime;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Goal {
    private Player player;
    private List<Player> assists;
    private LocalDateTime receivedAt;

    public Goal(Player player, List<Player> assists, LocalDateTime receivedAt) {
        this.player = player;
        this.assists = assists;
        this.receivedAt = receivedAt;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Player> getAssists() {
        return assists;
    }

    public void setAssists(List<Player> assists) {
        this.assists = assists;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Goal goal = (Goal) object;
        return player.equals(goal.player) &&
                java.util.Objects.equals(assists, goal.assists) &&
                receivedAt.equals(goal.receivedAt);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), player, assists, receivedAt);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Goal{" +
                "player=" + player +
                ", assists=" + assists +
                ", receivedAt=" + receivedAt +
                '}';
    }
}
