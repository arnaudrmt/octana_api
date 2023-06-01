package fr.first92.commons;

public class ServerManager {

    private String name;
    private String type;
    private Integer port;
    private String status;
    private Integer players;
    private Integer maxParty;
    private Integer maxPlayers;

    public ServerManager() {
    }

    public ServerManager(String name, String type, Integer port, String status, Integer players, Integer maxParty,
                         Integer maxPlayers) {
        this.name = name;
        this.type = type;
        this.port = port;
        this.status = status;
        this.players = players;
        this.maxParty = maxParty;
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPlayers() {
        return players;
    }

    public void setPlayers(Integer players) {
        this.players = players;
    }

    public Integer getMaxParty() {
        return maxParty;
    }

    public void setMaxParty(Integer maxParty) {
        this.maxParty = maxParty;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
