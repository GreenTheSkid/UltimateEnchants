package me.greenv1.ultimateenchants.enchants;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.lang.reflect.Field;

public class fairFight extends Enchantment implements Listener {


    public fairFight() {
        super(101);
    }


    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        int playersNear = 0;
        ItemStack chestplate = e.getPlayer().getInventory().getChestplate();
        for (Entity players : e.getPlayer().getNearbyEntities(e.getTo().getX(), e.getTo().getY(), e.getTo().getZ())) {
            if(e.getTo().distanceSquared(players.getLocation()) <= 10) {
                playersNear = playersNear + 1;
            }
            if (playersNear >=2) {
                if (chestplate.containsEnchantment(this)) {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 80, 0));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 80, 0));
                }

            }
        }
    }




    @Override
    public String getName() {
        return "Fair Fight";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ARMOR;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

    public static boolean register() {
        boolean registered = true;
        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);

            Enchantment.registerEnchantment(new fairFight());

        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            registered = false;
            e.printStackTrace();
        }

        return registered;
    }

}
