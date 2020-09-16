package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.time.LocalDateTime;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Game {
    private int id;
    private int host_id;
    private int guest_id;
    private LocalDateTime start;
    private LocalDateTime end;
    private String rinkLocation; // the address of the ice rink used for home games

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Game game = (Game) object;
        return id == game.id &&
                host_id == game.host_id &&
                guest_id == game.guest_id &&
                java.util.Objects.equals(start, game.start) &&
                java.util.Objects.equals(end, game.end) &&
                java.util.Objects.equals(rinkLocation, game.rinkLocation);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, host_id, guest_id, start, end, rinkLocation);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHost_id() {
        return host_id;
    }

    public void setHost_id(int host_id) {
        this.host_id = host_id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
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

    public Game(int id, int host_id, int guest_id, LocalDateTime start, LocalDateTime end, String rinkLocation) {
        this.id = id;
        this.host_id = host_id;
        this.guest_id = guest_id;
        this.start = start;
        this.end = end;
        this.rinkLocation = rinkLocation;
    }
}
