package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Penalty {
    public enum Length {
        LIFE,
        MATCH,
        TENMINUTES,
        FIVEMINUTES,
        TWOMINUTES,
    }

    private String name;
    private String description;
    private Length length;

    public Penalty(String name, String description, fontys.sem3.service.model.Penalty.Length length) {
        this.name = name;
        this.description = description;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public fontys.sem3.service.model.Penalty.Length getLength() {
        return length;
    }

    public void setLength(fontys.sem3.service.model.Penalty.Length length) {
        this.length = length;
    }
}
