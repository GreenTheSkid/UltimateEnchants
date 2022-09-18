package me.greenv1.ultimateenchants.enchants;

import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;

public class enchantHandler {

    private static enchantHandler instance;

    public enchantHandler() {
        instance = this;
    }

    public static enchantHandler getInstance() {
        return instance;
    }

    public HashMap<String, Enchantment> enchants = new HashMap<>();

    public HashMap<String, Enchantment> getEnchants() {
        return enchants;
    }

    public void addEnchant(Enchantment enchantment) {
        enchants.put(enchantment.getName(), enchantment);
    }
}
