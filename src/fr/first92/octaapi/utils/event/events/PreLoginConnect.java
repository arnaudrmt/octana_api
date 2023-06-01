package fr.first92.octaapi.utils.event.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PreLoginConnect implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {

        if(!e.getHostname().split(":")[0].equalsIgnoreCase("151.80.47.196")) {
            e.setKickMessage("You're only allowed to access the server without the proper ip");
            e.setResult(PlayerLoginEvent.Result.KICK_FULL);
        }
    }
}
