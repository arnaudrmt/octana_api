package fr.first92.octaapi.utils.event;

import fr.first92.octaapi.Api;
import fr.first92.octaapi.utils.event.events.NoFoodEvent;
import fr.first92.octaapi.utils.event.events.PreLoginConnect;
import org.bukkit.plugin.PluginManager;

public class UtilsEventsManager {

    public void registerEvents() {

        Api api = Api.getInstance();
        PluginManager pm = api.getServer().getPluginManager();

        pm.registerEvents(new NoFoodEvent(), api);
        pm.registerEvents(new PreLoginConnect(), api);
    }
}
