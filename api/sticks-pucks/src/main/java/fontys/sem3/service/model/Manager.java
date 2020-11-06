package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Manager {
    private int accountId;
    private String role;

    public Manager(int id) {
        this.accountId = id;
        this.role = "Manager";
    }

    public Manager(int id, String role) {
        this.accountId = id;
        this.role = role;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
        return accountId == manager.accountId &&
                role.equals(manager.role);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), accountId, role);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Manager{" +
                "account_id=" + accountId +
                ", role='" + role + '\'' +
                '}';
    }
}
