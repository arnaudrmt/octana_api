package fr.first92.commons;

public class ServerType {

    private String name;
    private int maxPlayers;
    private int maxParty;

    ServerType() {}

    public ServerType(String name, int maxPlayers, int maxParty) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.maxParty = maxParty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxParty() {
        return maxParty;
    }

    public void setMaxParty(int maxParty) {
        this.maxParty = maxParty;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public enum Types {

        LOBBY("lobby", 99, 20),
        KTP2017("ktp2017", 1, 10),
        MURDER("murder", 2, 8),
        MIDNIGHT("midnight", 10, 100),
        NPC("npc", 1, 10);

        private String name;
        private int maxParty;
        private int maxPlayers;

        Types(String name, int maxParty, int maxPlayers) {
            this.name = name;
            this.maxParty = maxParty;
            this.maxPlayers = maxPlayers;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMaxParty() {
            return maxParty;
        }

        public void setMaxParty(int maxParty) {
            this.maxParty = maxParty;
        }

        public int getMaxPlayers() {
            return maxPlayers;
        }

        public void setMaxPlayers(int maxPlayers) {
            this.maxPlayers = maxPlayers;
        }
    }
}
