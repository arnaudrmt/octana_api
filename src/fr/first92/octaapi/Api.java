package fr.first92.octaapi;

import fr.first92.commons.ServerManager;
import fr.first92.octaapi.network.data.ServerAccess;
import fr.first92.octaapi.network.data.redis.RedisAccess;
import fr.first92.octaapi.network.data.redis.messages.RedisMessageReceiver;
import fr.first92.octaapi.network.event.NetworkEventsManager;
import fr.first92.octaapi.utils.event.UtilsEventsManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Arrays;

public final class Api extends JavaPlugin {

    private static Api instance;
    private String serverName;

    @Override
    public void onLoad() {

        File file = new File("");
        this.serverName = Arrays.stream(file.getAbsolutePath().split("/")).skip(
                Arrays.stream(file.getAbsolutePath().split("/")).count() - 1).findFirst().get();

        System.out.println(serverName);

        RedisAccess.init();

        ServerAccess serverAccess = new ServerAccess(serverName);
        ServerManager serverManager = serverAccess.getServer();

        serverManager.setStatus("loading");

        serverAccess.sendServerToRedis(serverManager);
    }

    @Override
    public void onEnable() {

        instance = this;

        Bukkit.getWorlds().forEach(w -> w.setAutoSave(false));

        new NetworkEventsManager().registerEvents();
        new UtilsEventsManager().registerEvents();

        new RedisMessageReceiver().subscribe();

        ServerAccess serverAccess = new ServerAccess(serverName);
        ServerManager serverManager = serverAccess.getServer();

        serverManager.setStatus("started");

        serverAccess.sendServerToRedis(serverManager);
    }

    @Override
    public void onDisable() {

        Bukkit.getWorlds().forEach(w -> Bukkit.getServer().unloadWorld(w, true));

        ServerAccess serverAccess = new ServerAccess(getServer().getServerName());
        ServerManager serverManager = new ServerAccess(getServer().getServerName()).getServer();

        serverAccess.removeFromRedis(serverManager);

        RedisAccess.close();
    }

    public static Api getInstance() {
        return instance;
    }

    public String getServerName() {
        return serverName;
    }
}
