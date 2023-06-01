package fr.first92.commons;

public enum RankEnum {

    PLAYER(100, "player", "§7", ""),
    VIP(90, "vip", "§e", "[VIP] "),
    VIP_PLUS(80, "vip_plus", "§b", "[VIP+] "),
    MVP(70, "mvp", "§3", "[MVP] "),
    STAFF(60, "staff", "§5", "[STAFF] "),
    BUILDER(50, "builder", "§a", "[BUILDER] "),
    MODERATOR(40, "moderator", "§6", "[MOD.] "),
    DEVELOPER(30, "developer", "§5", "[DEV.] "),
    ADMIN(0, "admin", "§c", "[Admin] ")
    ;

    private Integer power;
    private String name;
    private String color;
    private String prefix;

    RankEnum(Integer power, String name, String color, String prefix) {
        this.power = power;
        this.name = name;
        this.color = color;
        this.prefix = prefix;
    }

    public Integer getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getColor() {
        return color;
    }
}
