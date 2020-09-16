package fontys.sem3.service.repository;

import fontys.sem3.service.model.Team;
import fontys.sem3.service.model.Account;
import fontys.sem3.service.model.Penalty;
import fontys.sem3.service.model.Manager;
import fontys.sem3.service.model.Player;
import fontys.sem3.service.model.Player.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class FakeDataStore {
    private final List<Team> teams = new ArrayList<>();
    private final List<Account> users = new ArrayList<>();
    private final List<Manager> managers = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();
    private final List<Penalty> penalties = new ArrayList<>();

    public FakeDataStore() {
        LocalDate date = LocalDate.now(); // Create a date object

        users.add(new Account(1, "Ron Berteling", "test@test.test", LocalDate.now()));
        users.add(new Account(2, "NiCo", "test@test.test", LocalDate.now()));
        users.add(new Account(3, "Roger", "test@test.test", LocalDate.now()));
        users.add(new Account(4, "Rebecca", "test@test.test", LocalDate.now()));
        users.add(new Account(5, "Karina", "test@test.test", LocalDate.now()));

        managers.add(new Manager(2, "Kemphanen Owner"));
        managers.add(new Manager(1, "Icehawks GM"));

        penalties.add(new Penalty( "Roughing", "Roughing shall be considered any act where a player uses unnecessary force to push or shove an opponent or makes avoidable physical contact with an opponent after the whistle.", Penalty.Length.tenminutes));
        penalties.add(new Penalty( "Fighting", "The player started a fight on the ice", Penalty.Length.fiveminutes));

        Team hawks = new Team(1, "Icehawks", "server/pics/1", "IJssportcentrum Eindhoven");
        Position center = Player.Position.RW;
        Shoots left = Player.Shoots.L;
        Player player = new Player(1, 150, 55, center, left);
        hawks.changeCaptain(player);
        hawks.addAssistant(player);
        hawks.addPlayerToRoster(player);
        teams.add(hawks);
        teams.add(new Team(2, "Kemphanen", "server/pics/2", "IJssportcentrum Eindhoven"));

        players.add(player);
        players.add(new Player(2, 180, 80, center, left));
        players.add(new Player(3, 123, 55, center, left));
    }

    public Account getUser(int id) {
        for (Account account : users) {
            if (account.getId() == id)
                return account;
        }
        return null;
    }

    public Player getPlayer(int id) {
        for (Player account : players) {
            if (account.getAccount_id() == id)
                return account;
        }
        return null;
    }

    public Manager getManager(int id) {
        for (Manager account : managers) {
            if (account.getAccount_id() == id)
                return account;
        }
        return null;
    }

    public Team getTeam(String name) {
        for (Team team : teams) {
            if (team.getName() == name)
                return team;
        }
        return null;
    }

    public Team getTeam(int id) {
        for (Team team : teams) {
            if (team.getId() == id)
                return team;
        }
        return null;
    }

    public Penalty getPenalty(String name) {
        for (Penalty penalty : penalties) {
            if (penalty.getName().equals(name))
                return penalty;
        }
        return null;
    }
    public List<Team> getTeams() { return teams; }
    public List<Penalty> getAllPenalties() { return penalties; }
    public List<Account> getUsers() {
        return users;
    }
    public List<Manager> getManagers() {
        return managers;
    }
    public List<Player> getPlayers() { return players; }

    public boolean deleteUser(int id) {
        Account account = getUser(id);
        if (account == null){
            return false;
        }

        return users.remove(account);
    }

    public boolean deleteManager(int id) {
        Manager manager = getManager(id);
        if (manager == null){
            return false;
        }
        return managers.remove(manager);
    }

    public boolean deletePlayer(int id) {
        Player player = getPlayer(id);
        if (player == null){
            return false;
        }
        return players.remove(player);
    }

    public boolean add(Account account) {
        users.add(account);
        return true;
    }

    public boolean add(Manager manager) {
        managers.add(manager);
        return true;
    }

    public boolean add(Player player) {
        players.add(player);
        return true;
    }

    public boolean add(Team team) {
        teams.add(team);
        return true;
    }

    public boolean update(Account account) {
        Account old = this.getUser(account.getId());
        if (old == null) {
            return false;
        }
        old.setName(account.getName());
        return true;
    }

    public boolean update(Manager account) {
        Manager old = this.getManager(account.getAccount_id());
        if (old == null) {
            return false;
        }
       // TODO: set the fields here
        return true;
    }

    public boolean update(Player account) {
        Player old = this.getPlayer(account.getAccount_id());
        if (old == null) {
            return false;
        }
        // TODO: set the fields here
        return true;
    }


    public boolean update(Team team) {
        Team old = this.getTeam(team.getId());
        if (old == null) {
            return false;
        }
        // TODO: set the fields here
        return true;
    }
}
