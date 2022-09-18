package me.greenv1.ultimateenchants;


import java.util.ArrayList;

import me.greenv1.ultimateenchants.enchants.enchantHandler;
import me.greenv1.ultimateenchants.enchants.fairFight;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class UltimateEnchants extends JavaPlugin implements Listener {

    public fairFight ench = new fairFight();

    @Override
    public void onEnable() {
        enchantHandler.getInstance().addEnchant(new fairFight());
        Bukkit.getPluginManager().registerEvents(this, this);

        if (fairFight.register()) {
            System.out.println("Registering enchantment");
        } else {
            System.out.println("Error registering enchantment");
        }
        this.getServer().getPluginManager().registerEvents(ench, this);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        item.addEnchantment(new fairFight(), 1);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + ench.getName() + " I");
        meta.setDisplayName(ChatColor.GOLD + "Good Chestplate");
        meta.setLore(lore);
        item.setItemMeta(meta);
        event.getPlayer().getInventory().addItem(item);

    }






    /*public fairFight ench = new fairFight(101);

    public void onEnable() {
        Enchantment.registerEnchantment(ench);


        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(ench, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + ench.getName() + " I");
        meta.setDisplayName(ChatColor.GOLD + "Good Chestplate");
        meta.setLore(lore);
        item.setItemMeta(meta);
        item.addUnsafeEnchantment(ench, 1);

        player.getInventory().addItem(item);
    }

    @SuppressWarnings("unchecked")
    public void onDisable() {
        try {
            Field byIdField = Enchantment.class.getDeclaredField("byId");
            Field byNameField = Enchantment.class.getDeclaredField("byName");

            byIdField.setAccessible(true);
            byNameField.setAccessible(true);

            HashMap<Integer, Enchantment> byId = (HashMap<Integer, Enchantment>) byIdField.get(null);
            HashMap<Integer, Enchantment> byName = (HashMap<Integer, Enchantment>) byNameField.get(null);

            if (byId.containsKey(ench.getId())) {
                byId.remove(ench.getId());
            }

            if (byName.containsKey(ench.getName())) {
                byName.remove(ench.getName());
            }
        } catch (Exception ignored) {
        }
    }

    private void LoadEnchantments() {
        try {
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Enchantment.registerEnchantment(ench);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
