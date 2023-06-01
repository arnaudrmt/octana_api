package fr.first92.octaapi.network.data;

import fr.first92.commons.Account;
import fr.first92.octaapi.network.data.redis.RedisAccess;
import org.bukkit.entity.Player;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

public class AccountAccess {

    private String REDIS_KEY = "account:";
    private Player p;

    public AccountAccess(Player p) {
        this.p = p;
    }

    public Account getAccount() {

        final RedisAccess redisAccess = RedisAccess.instance;
        final RedissonClient redissonClient = redisAccess.getRedissonClient();
        final RBucket<Account> accountRBucket = redissonClient.getBucket(REDIS_KEY + p.getUniqueId().toString());

        return accountRBucket.get();
    }

    public void sendAccountToRedis(Account account) {

        final RedissonClient redissonClient = RedisAccess.instance.getRedissonClient();
        final String key = REDIS_KEY + account.getUUID();
        final RBucket<Account> accountRBucket = redissonClient.getBucket(key);

        accountRBucket.set(account);
    }
}
