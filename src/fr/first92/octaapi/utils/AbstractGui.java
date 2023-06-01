package fr.first92.octaapi.utils;

import fr.first92.octaapi.Api;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractGui implements Listener {

    private String name;
    private Integer size;
    public Player p;

    public Inventory inv;

    public AbstractGui(String name, Integer size, Player player) {
        this.name = name;
        this.size = size;
        this.p = player;

        this.inv = Bukkit.createInventory(null, size, name);

        Api.getInstance().getServer().getPluginManager().registerEvents(this, Api.getInstance());
    }

    public void init() {}

    public final void open() {
        init();
        p.openInventory(this.inv);
    }

    public void addItem(Integer slot, ItemStack itemStack, ActionItem actionItem) {

        this.inv.setItem(slot, itemStack);
        actionItem.itemStack = itemStack;
    }

    public abstract static class ActionItem implements Listener {

        public ItemStack itemStack;

        public ActionItem() {
            Api.getInstance().getServer().getPluginManager().registerEvents(this, Api.getInstance());
        }

        @EventHandler
        public void onInventoryClick(InventoryClickEvent e) {

            if(e.getCurrentItem().equals(itemStack) && e.getCurrentItem() != null
                    && e.getCurrentItem().getType() != null && e.getClickedInventory() != null
            && e.getInventory().getType() != null) {

                action(e);
            }

            e.setCancelled(true);
        }

        protected abstract void action(InventoryClickEvent e);

        @EventHandler
        public void onInventoryClose(InventoryCloseEvent e) {
            HandlerList.unregisterAll(this);
        }
    }
}
