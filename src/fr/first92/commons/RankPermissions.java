package fr.first92.commons;

public class RankPermissions {

    private String name;
    private Integer power;
    private String permissions;

    public RankPermissions() {}

    public RankPermissions(String name, Integer power, String permissions) {
        this.name = name;
        this.power = power;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public Integer getPower() {
        return power;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
