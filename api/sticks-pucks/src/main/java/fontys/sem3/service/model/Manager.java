package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Manager {
    private int account_id;
    private String role;

    public Manager(int id) {
        this.account_id = id;
        this.role = "Manager";
    }

    public Manager(int id, String role) {
        this.account_id = id;
        this.role = role;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Manager manager = (Manager) object;
        return account_id == manager.account_id &&
                role.equals(manager.role);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), account_id, role);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Manager{" +
                "account_id=" + account_id +
                ", role='" + role + '\'' +
                '}';
    }
}
