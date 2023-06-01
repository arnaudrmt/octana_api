package fr.first92.octaapi.game.event.events;

import fr.first92.octaapi.Api;
import fr.first92.octaapi.game.GameManager;
import fr.first92.octaapi.game.gamestate.GameState;
import fr.first92.octaapi.game.gamestate.GameStateManager;
import fr.first92.octaapi.game.schedulers.GameStartScheduler;
import fr.first92.octaapi.network.data.ServerAccess;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GameJoinEvent implements Listener {

    private GameManager gameManager;

    public GameJoinEvent(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onGameJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        p.teleport(p.getWorld().getSpawnLocation());

        gameManager.sendHelp(p);

        if(new GameStateManager().isState(GameState.WAITING)) {

            p.setGameMode(GameMode.ADVENTURE);

            if(new ServerAccess(Api.getInstance().getServerName()).getServer().getPlayers() >= gameManager.minStart)
                new GameStartScheduler(gameManager, gameManager.minStart);

        } else {

            p.setGameMode(GameMode.SPECTATOR);
        }

        p.setHealth(p.getMaxHealth());
        p.setFoodLevel(20);
        p.getActivePotionEffects().clear();
    }
}
