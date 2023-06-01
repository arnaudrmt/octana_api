package fr.first92.octaapi.network.data.redis.messages;

import fr.first92.commons.ServerManager;
import fr.first92.octaapi.Api;
import fr.first92.octaapi.network.data.ServerAccess;
import fr.first92.octaapi.network.data.ServerTypeAccess;
import fr.first92.octaapi.network.data.redis.RedisAccess;
import org.redisson.api.RedissonClient;

import java.util.List;

public class RedisMessageReceiver {

    RedissonClient redissonClient = RedisAccess.instance.getRedissonClient();

    public void subscribe() {

        redissonClient.getTopic("spigot").addListener((s, o) -> {

            List<String> l = (List<String>) o;

            if(l.size() == 2 && l.get(0).equalsIgnoreCase("server") &&
                    l.get(1).equalsIgnoreCase(Api.getInstance().getServerName())) {

                ServerAccess serverAccess = new ServerAccess(l.get(1));
                ServerManager server = serverAccess.getServer();

                server.setMaxParty(new ServerTypeAccess(server.getType()).getServerType().getMaxParty());
                server.setMaxPlayers(new ServerTypeAccess(server.getType()).getServerType().getMaxPlayers());

                serverAccess.sendServerToRedis(server);
            }

            if(l.get(0).equalsIgnoreCase(Api.getInstance().getServerName())) {

                if(l.contains("stop")) {

                    Api.getInstance().getServer().shutdown();
                }
            }
        });
    }
}
