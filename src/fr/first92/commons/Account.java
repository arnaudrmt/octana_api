package fr.first92.commons;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class Account {

    private UUID uuid;
    private String username;
    private RankEnum rank;
    private Integer coins;

    private List<UUID> friends;

    public Account() {}

    public Account(UUID uuid, String username, RankEnum rank, Integer coins, List<UUID> friends) {
        this.uuid = uuid;
        this.username = username;
        this.rank = rank;
        this.coins = coins;
        this.friends = friends;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RankEnum getRank() {
        return rank;
    }

    public void setRank(RankEnum rank) {
        this.rank = rank;
    }

    public Integer getCoins() {
        return coins;
    }

    public void addCoins(Integer amount) {
        this.coins = getCoins() + amount;
    }

    public void removeCoins(Integer amount) {
        this.coins = getCoins() - amount;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public List<UUID> getFriends() {
        return friends;
    }

    public void addFriend(Player friend) {
        friends.add(friend.getUniqueId());
    }

    public void removeFriend(Player friend) {
        friends.remove(friend.getUniqueId());
    }
}
