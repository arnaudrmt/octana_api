package fr.first92.octaapi.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class ItemStackUtils {

    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private SkullMeta skullMeta;

    public ItemStackUtils(Material mat, String name, Integer amount) {

        itemStack = new ItemStack(mat, amount);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
    }

    public void setUnbreakable() {

        if(skullMeta == null) itemMeta.spigot().setUnbreakable(true);
        else skullMeta.spigot().setUnbreakable(true);
    }

    public void setDisplayName(String name) {

        if(skullMeta == null) itemMeta.setDisplayName(name);
        else skullMeta.setDisplayName(name);
    }

    public void setLore(List<String> lore) {

        if(skullMeta == null) itemMeta.setLore(lore);
        itemMeta.setLore(lore);
    }

    public void setOwner(String owner) {

        skullMeta.setOwner(owner);
    }

    public void addFlag(ItemFlag itemFlag) {

        if(skullMeta == null) itemMeta.addItemFlags(itemFlag);
        else skullMeta.addItemFlags(itemFlag);
    }

    public void setMeta(Integer meta) {

        itemStack.setDurability(Short.parseShort(meta.toString()));
    }

    public ItemStack build() {

        this.itemStack.setItemMeta(itemMeta);

        System.out.println(this.itemStack);
        System.out.println(this.itemMeta);

        return this.itemStack;
    }

    public ItemStack buildSkull() {

        this.itemStack.setItemMeta(skullMeta);

        return itemStack;
    }
}
