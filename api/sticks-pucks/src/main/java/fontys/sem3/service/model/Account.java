package fontys.sem3.service.model;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.util.Date;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Account implements Serializable{
    private static final long serialVersionUID = -5998367898242256562L;

    private int id;
    private String name;
    private String email;
    private Date birtdate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Constructor
     */
    public Account(int id, String name, String email, Date birtdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birtdate = birtdate;
    }

    /**
     * Constructor
     */
     public Account(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(Date birtdate) {
        this.birtdate = birtdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return birtdate == account.birtdate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(birtdate);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", email=" + email +
                ", birtdate=" + birtdate +
                '}';
    }
}
