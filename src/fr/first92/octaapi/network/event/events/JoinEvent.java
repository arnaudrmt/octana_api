package fr.first92.octaapi.network.event.events;

import fr.first92.commons.Account;
import fr.first92.commons.ServerManager;
import fr.first92.octaapi.Api;
import fr.first92.octaapi.network.data.ServerAccess;
import fr.first92.octaapi.network.data.redis.RedisAccess;
import fr.first92.octaapi.network.permissions.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        final RedisAccess redisAccess = RedisAccess.instance;
        final RedissonClient redissonClient = redisAccess.getRedissonClient();
        final RBucket<Account> accountRBucket = redissonClient.getBucket("account:" + p.getUniqueId().toString());

        final Account account = accountRBucket.get();

        ServerAccess serverProvider = new ServerAccess(Api.getInstance().getServerName());
        ServerManager serverManager = serverProvider.getServer();

        serverManager.setPlayers(Bukkit.getOnlinePlayers().size());

        serverProvider.sendServerToRedis(serverManager);

        new Permissions().addRankPermissionsToPlayer(p, account.getRank());
    }
}
