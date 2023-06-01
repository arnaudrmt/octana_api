package fr.first92.octaapi.network.data.redis.messages;

import fr.first92.octaapi.network.data.redis.RedisAccess;
import org.redisson.api.RedissonClient;

import java.util.List;

public class RedisMessageSender {

    RedissonClient redissonClient = RedisAccess.instance.getRedissonClient();

    public void send(List<String> args) {

        redissonClient.getTopic("bungee").publish(args);
    }
}
