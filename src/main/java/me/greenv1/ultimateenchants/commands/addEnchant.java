package me.greenv1.ultimateenchants.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.greenv1.ultimateenchants.enchants.enchantHandler;
import org.bukkit.enchantments.Enchantment;

public class addEnchant implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("addenchant")) {
            if (p.hasPermission("ultimateenchants.addEnchant")) {
                if (args.length < 1) {
                    p.sendMessage(ChatColor.RED + "Please enter an enchantment!");
                    return false;
                }

                if (args.length < 2) {
                    p.sendMessage(ChatColor.RED + "Please enter a level!");
                }

                if (args.length >= 2) {
                    if (enchantHandler.getInstance().enchants.containsKey(args[1])) {
                        Enchantment ench = enchantHandler.getInstance().enchants.get(args[1]);
                        p.getServer().getPlayer(p.getName()).getItemInHand().addUnsafeEnchantment(ench, 1);
                    } else {p.sendMessage(ChatColor.RED + "Please enter a valid enchant!");}
                }

            }
        }

        return false;
    }
}
