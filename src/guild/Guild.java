package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }
    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }
    public void promotePlayer(String name) {
        boolean isFound = false;
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (player.getRank().equals("Trial")) {
                    player.setRank("Member");
                    isFound = true;

                }
            }
            if (isFound) {
                break;
            }

        }
    }
    public void demotePlayer(String name) {
        boolean isFound = false;
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
                isFound = true;
            }
            if (isFound) {
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        Player[] array = new Player[roster.size()];
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getClazz().equals(clazz)) {
                array[i] = roster.get(i);
                roster.remove(i);
            }

        }

        return array;
    }

    public int count() {
        return roster.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:",name)).append(System.lineSeparator());

        for (Player player : roster) {
            sb.append(player);

        }
        return sb.toString();
    }
}
