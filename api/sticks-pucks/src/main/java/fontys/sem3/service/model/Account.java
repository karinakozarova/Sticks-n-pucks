package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.time.LocalDate;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Account {
    private int id;
    private String name;
    private String email;
    private LocalDate birtdate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account(int id, String name, String email, LocalDate birtdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birtdate = birtdate;
    }

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

    public LocalDate getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(LocalDate birtdate) {
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
                ", birtdate=" + birtdate +
                '}';
    }
}
