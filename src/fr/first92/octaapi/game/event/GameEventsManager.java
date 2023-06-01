package fr.first92.octaapi.game.event;

import fr.first92.octaapi.game.GameManager;
import fr.first92.octaapi.game.event.events.GameJoinEvent;
import fr.first92.octaapi.game.event.events.GameWaitingEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GameEventsManager {

    public void registerEvents(JavaPlugin mainClass, GameManager gameManager) {

        PluginManager pm = mainClass.getServer().getPluginManager();

        pm.registerEvents(new GameJoinEvent(gameManager), mainClass);
        pm.registerEvents(new GameWaitingEvent(), mainClass);
    }
}
