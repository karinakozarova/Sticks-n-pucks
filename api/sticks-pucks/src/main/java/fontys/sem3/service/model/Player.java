package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Player{

    public enum Position {
        LW,
        RW,
        C,
        LD,
        RD,
        GK
    }

    public enum Shoots {
        L,
        R
    }
    private int accountId;
    private int height;
    private int weight;
    private Position position;
    private Shoots shoots;

    /**
     * Constructor
     */
    public Player(int id, int height, int weight, Position position, Shoots shoots) {
        this.accountId = id;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.shoots = shoots;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Player player = (Player) object;
        return accountId == player.accountId &&
                height == player.height &&
                weight == player.weight &&
                position == player.position &&
                shoots == player.shoots;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), accountId, height, weight, position, shoots);
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public fontys.sem3.service.model.Player.Position getPosition() {
        return position;
    }

    public void setPosition(fontys.sem3.service.model.Player.Position position) {
        this.position = position;
    }

    public fontys.sem3.service.model.Player.Shoots getShoots() {
        return shoots;
    }

    public void setShoots(fontys.sem3.service.model.Player.Shoots shoots) {
        this.shoots = shoots;
    }
}
