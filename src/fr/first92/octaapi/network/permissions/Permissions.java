package fr.first92.octaapi.network.permissions;

import fr.first92.commons.RankEnum;
import fr.first92.commons.RankPermissions;
import fr.first92.octaapi.Api;
import fr.first92.octaapi.network.data.redis.RedisAccess;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class Permissions {

    private HashMap<UUID, PermissionAttachment> playerPermissions = new HashMap<UUID, PermissionAttachment>();

    public void addRankPermissionsToPlayer(Player p, RankEnum rank) {

        PermissionAttachment attachment = p.addAttachment(Api.getInstance());
        playerPermissions.put(p.getUniqueId(), attachment);

        PermissionAttachment pperms = playerPermissions.get(p.getUniqueId());

        Arrays.stream(RankEnum.values()).filter(rs -> rs.getPower() >= rank.getPower()).forEach(rs -> {

            final RedisAccess redisAccess = RedisAccess.instance;
            final RedissonClient redissonClient = redisAccess.getRedissonClient();
            final RBucket<RankPermissions> accountRBucket = redissonClient.getBucket("rank:" + rs.getName());

            final RankPermissions rankPermissions = accountRBucket.get();

            Arrays.stream(rankPermissions.getPermissions().split(",")).forEach(rs1 -> {
                pperms.setPermission(rs1, true);
            });
        });
    }
}
