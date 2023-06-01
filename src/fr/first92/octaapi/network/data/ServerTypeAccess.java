package fr.first92.octaapi.network.data;

import fr.first92.commons.ServerType;
import fr.first92.octaapi.network.data.redis.RedisAccess;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

public class ServerTypeAccess {

    private String REDIS_KEY = "server_type:";
    private String type;

    public ServerTypeAccess(String type) {
        this.type = type;
    }

    public ServerType getServerType() {

        final RedisAccess redisAccess = RedisAccess.instance;
        final RedissonClient redissonClient = redisAccess.getRedissonClient();
        final RBucket<ServerType> accountRBucket = redissonClient.getBucket(REDIS_KEY + type);

        return accountRBucket.get();
    }

    public void sendServerTypeToRedis(ServerType serverType) {

        final RedissonClient redissonClient = RedisAccess.instance.getRedissonClient();
        final String key = REDIS_KEY + serverType.getName();
        final RBucket<ServerType> accountRBucket = redissonClient.getBucket(key);

        accountRBucket.set(serverType);
    }
}
