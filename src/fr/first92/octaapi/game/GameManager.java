package fr.first92.octaapi.game;

import fr.first92.commons.ServerManager;
import fr.first92.octaapi.Api;
import fr.first92.octaapi.game.command.GameCommandsManager;
import fr.first92.octaapi.game.event.GameEventsManager;
import fr.first92.octaapi.game.gamestate.GameState;
import fr.first92.octaapi.game.gamestate.GameStateManager;
import fr.first92.octaapi.network.data.ServerAccess;
import fr.first92.octaapi.network.data.ServerTypeAccess;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public abstract class GameManager {

    private String type;
    public Integer timerTime;
    public Integer minStart;
    public Integer maxPlayers;
    public Integer maxParty;

    public GameManager(JavaPlugin mainClass, String type, Integer timerTime, Integer minStart) {

        this.type = type;
        this.timerTime = timerTime;
        this.minStart = minStart;

        this.maxPlayers = new ServerTypeAccess(type).getServerType().getMaxPlayers();
        this.maxParty = new ServerTypeAccess(type).getServerType().getMaxParty();

        new GameStateManager().setState(GameState.WAITING);

        new GameEventsManager().registerEvents(mainClass, this);
        new GameCommandsManager().registerCommands(mainClass, this);

        ServerAccess serverAccess = new ServerAccess(Api.getInstance().getServerName());
        ServerManager serverManager = serverAccess.getServer();

        serverManager.setMaxParty(maxParty);
        serverManager.setMaxPlayers(maxPlayers);

        serverAccess.sendServerToRedis(serverManager);
    }

    public void preLaunch() {

        Bukkit.getOnlinePlayers().stream().filter(rs -> rs.getGameMode().equals(GameMode.ADVENTURE)).forEach(player -> {
            player.setLevel(0);
        });

        launchGame();
    }

    public abstract void launchGame();

    public void sendHelp(Player p) {

        if(description() != null) {

            p.sendMessage("§e|---------- §6" + type.substring(0, 1).toUpperCase() + type.substring(1) + "§e ----------|");

            p.sendMessage(" ");

            description().forEach(rs -> p.sendMessage("§7" + rs));

            p.sendMessage(" ");

            p.sendMessage("§e|------------------------------|");

            p.sendMessage(" ");
        }
    }

    public Integer getMaxParty() {
        return maxParty;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public abstract List<String> description();
}
