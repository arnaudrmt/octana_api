package fr.first92.octaapi.network.event;

import fr.first92.octaapi.Api;
import fr.first92.octaapi.network.event.events.JoinEvent;
import fr.first92.octaapi.network.event.events.QuitEvent;
import org.bukkit.plugin.PluginManager;

public class NetworkEventsManager {


    public void registerEvents() {

        Api api = Api.getInstance();
        PluginManager pm = api.getServer().getPluginManager();

        pm.registerEvents(new JoinEvent(), api);
        pm.registerEvents(new QuitEvent(), api);
    }
}
