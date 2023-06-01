package fr.first92.octaapi.game.command.commands;

import fr.first92.octaapi.Api;
import fr.first92.octaapi.game.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GameCommand implements CommandExecutor {

    private GameManager gameManager;

    public GameCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender.hasPermission("octana.game.start") || sender.hasPermission("octana.*")) {
            if(args[0].equalsIgnoreCase("start")) {
                Api.getInstance().getServer().getScheduler().cancelAllTasks();
                gameManager.preLaunch();
            }

        } else return false;

        return false;
    }
}
