package fr.first92.octaapi.game.command;

import fr.first92.octaapi.game.GameManager;
import fr.first92.octaapi.game.command.commands.GameCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class GameCommandsManager {

    public void registerCommands(JavaPlugin mainClass, GameManager gameManager) {

        mainClass.getCommand("game").setExecutor(new GameCommand(gameManager));
    }
}
