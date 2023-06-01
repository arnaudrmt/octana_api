package fr.first92.octaapi.network.event.events;

import fr.first92.commons.ServerManager;
import fr.first92.octaapi.Api;
import fr.first92.octaapi.network.data.ServerAccess;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuitEvent(PlayerQuitEvent e) {

        Player p = e.getPlayer();
        ServerAccess serverProvider = new ServerAccess(Api.getInstance().getServerName());
        ServerManager serverManager = serverProvider.getServer();

        serverManager.setPlayers(Bukkit.getOnlinePlayers().size() - 1);

        serverProvider.sendServerToRedis(serverManager);

    }
}
