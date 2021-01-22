package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class GameInformation {
    private LocalDateTime start;
    private LocalDateTime end;
    private String rinkLocation; // the address of the ice rink used for home games

    /**
     * Constructor
     */
    public GameInformation(LocalDateTime start, LocalDateTime end, String rinkLocation) {
        this.start = start;
        this.end = end;
        this.rinkLocation = rinkLocation;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "GameInformation{" +
                "start=" + start +
                ", end=" + end +
                ", rinkLocation='" + rinkLocation + '\'' +
                '}';
    }
}
