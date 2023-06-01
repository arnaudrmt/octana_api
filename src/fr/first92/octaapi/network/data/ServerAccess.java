package fr.first92.octaapi.network.data;

import fr.first92.commons.ServerManager;
import fr.first92.octaapi.network.data.redis.RedisAccess;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

public class ServerAccess {

    private String REDIS_KEY = "servers:";
    private String server;

    public ServerAccess(String server) {
        this.server = server;
    }

    public ServerManager getServer() {

        final RedisAccess redisAccess = RedisAccess.instance;
        final RedissonClient redissonClient = redisAccess.getRedissonClient();
        final RBucket<ServerManager> accountRBucket = redissonClient.getBucket(REDIS_KEY + server);

        return accountRBucket.get();
    }

    public void sendServerToRedis(ServerManager serverManager) {

        final RedissonClient redissonClient = RedisAccess.instance.getRedissonClient();
        final String key = REDIS_KEY + serverManager.getName();
        final RBucket<ServerManager> accountRBucket = redissonClient.getBucket(key);

        accountRBucket.set(serverManager);
    }

    public void removeFromRedis(ServerManager serverManager) {

        final RedissonClient redissonClient = RedisAccess.instance.getRedissonClient();
        final String key = REDIS_KEY + serverManager.getName();
        final RBucket<ServerManager> accountRBucket = redissonClient.getBucket(key);

        accountRBucket.delete();
    }
}
