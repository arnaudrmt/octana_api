package fr.first92.octaapi.game.event.events;

import fr.first92.octaapi.game.gamestate.GameState;
import fr.first92.octaapi.game.gamestate.GameStateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class GameWaitingEvent implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {

        if(!new GameStateManager().isState(GameState.GAME)) {
            e.setCancelled(true);
        }
    }
}
