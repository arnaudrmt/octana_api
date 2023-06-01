package fr.first92.octaapi.utils.event.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoFoodEvent implements Listener {

    @EventHandler
    public void onFoodDrop(FoodLevelChangeEvent e) {

        e.setFoodLevel(20);
        e.setCancelled(true);
    }
}
