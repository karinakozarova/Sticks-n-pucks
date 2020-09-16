package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import fontys.sem3.service.model.Penalty;
import fontys.sem3.service.model.Player;
import java.time.LocalDateTime;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class ReceivedPenalty {
    private Penalty penalty;
    private Player player;
    private LocalDateTime receivedAt;

    public ReceivedPenalty(Penalty penalty, Player player, LocalDateTime receivedAt) {
        this.penalty = penalty;
        this.player = player;
        this.receivedAt = receivedAt;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ReceivedPenalty{" +
                "penalty=" + penalty +
                ", player=" + player +
                ", receivedAt=" + receivedAt +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ReceivedPenalty that = (ReceivedPenalty) object;
        return java.util.Objects.equals(penalty, that.penalty) &&
                java.util.Objects.equals(player, that.player) &&
                java.util.Objects.equals(receivedAt, that.receivedAt);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), penalty, player, receivedAt);
    }
}
