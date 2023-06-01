package fr.first92.octaapi.network.data.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

public class RedisAccess {

    public static RedisAccess instance;
    private RedissonClient redissonClient;

    public RedisAccess(RedisCredentials redisCredentials) {

        instance = this;
        this.redissonClient = initRedisson(redisCredentials);
    }

    public static void init(){

        new RedisAccess(new RedisCredentials("151.80.47.196", "octana", 6579));
    }

    public RedissonClient initRedisson(RedisCredentials redisCredentials) {

        final Config config = new Config();

        config.setCodec(new JsonJacksonCodec());
        config.setThreads(8);
        config.setNettyThreads(8);
        config.useSingleServer().setAddress(redisCredentials.toRedisUrl()).setPassword(redisCredentials.getPassword())
                .setDatabase(1).setClientName(redisCredentials.getClientName());

        return Redisson.create(config);
    }

    public static void close() {

        RedisAccess.instance.getRedissonClient().shutdown();
    }

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }
}
