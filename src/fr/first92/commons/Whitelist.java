package fr.first92.commons;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class Whitelist {

    private String server;
    boolean whitelisted;

    private List<UUID> playerWhitelisted;
    private List<RankEnum> rankWhitelisted;

    public Whitelist(String server, boolean whitelisted, List<UUID> playerWhitelisted, List<RankEnum> rankWhitelisted) {
        this.server = server;
        this.whitelisted = whitelisted;
        this.playerWhitelisted = playerWhitelisted;
        this.rankWhitelisted = rankWhitelisted;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public boolean isWhitelisted() {
        return whitelisted;
    }

    public void setWhitelisted(boolean whitelisted) {
        this.whitelisted = whitelisted;
    }

    public List<UUID> getPlayerWhitelisted() {
        return playerWhitelisted;
    }

    public List<RankEnum> getRankWhitelisted() {
        return rankWhitelisted;
    }

    public void addPlayer(Player p) {
        playerWhitelisted.add(p.getUniqueId());
    }

    public void removePlayer(Player p) {
        playerWhitelisted.remove(p);
    }

    public void addRank(RankEnum rank) {
        rankWhitelisted.add(rank);
    }

    public void removeRank(RankEnum rank) {
        rankWhitelisted.remove(rank);
    }
}
