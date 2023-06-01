package fr.first92.octaapi.game.schedulers;

import fr.first92.octaapi.Api;
import fr.first92.octaapi.game.GameManager;
import fr.first92.octaapi.game.gamestate.GameState;
import fr.first92.octaapi.game.gamestate.GameStateManager;
import fr.first92.octaapi.utils.Title;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartScheduler {

    GameManager game;

    int timer;
    int minStart;

    public GameStartScheduler(GameManager game, int minStart) {
        this.timer = game.timerTime;
        this.game = game;
        this.minStart = minStart;

        task.runTaskTimer(Api.getInstance(), 20, 20);
    }

    BukkitRunnable task = new BukkitRunnable(){

        @Override
        public void run() {

            if(Bukkit.getOnlinePlayers().stream().filter(rs -> rs.getGameMode().equals(GameMode.ADVENTURE)).count() >= minStart) {

                new GameStateManager().setState(GameState.COUNTDOWN);

                if(timer > 0) {

                    Bukkit.getOnlinePlayers().stream().filter(rs -> rs.getGameMode().equals(GameMode.ADVENTURE)).forEach(player -> {
                        player.setLevel(timer);

                        new Title().sendFullTitle(player, 10, 20, 10, "",

                                (timer <= game.timerTime && timer > game.timerTime / 2) ? ("§a" +  timer + "s") :
                                (timer <= game.timerTime / 2 && timer > game.timerTime / 3) ? ("§6" +  timer + "s") :
                                ("§c" + timer + "s")
                        );


                        player.playSound(player.getLocation(), Sound.NOTE_PIANO, 1, 100);
                    });
                }
            } else {
                new GameStateManager().setState(GameState.WAITING);
                cancel();
            }

            if(timer == 0) {
                new GameStateManager().setState(GameState.GAME);

                Bukkit.getOnlinePlayers().stream().filter(rs -> rs.getGameMode().equals(GameMode.ADVENTURE)).forEach(player -> {
                    new Title().sendTitle(player, 10, 20, 10, "§6Good Luck!");
                    player.playSound(player.getLocation(), Sound.NOTE_PIANO, 1, 100);
                });

                game.preLaunch();
                cancel();
            }

            timer --;
        }
    };
}
