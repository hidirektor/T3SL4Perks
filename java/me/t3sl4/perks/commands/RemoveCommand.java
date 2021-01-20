package me.t3sl4.perks.commands;

import me.t3sl4.perks.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import java.util.Iterator;

public class RemoveCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.CONSOLE);
        } else {
            if(cmd.getName().equalsIgnoreCase("viprem")) {
                Player s = (Player) sender;

                if(sender.hasPermission("t3sl4perks.viprem")) {
                    sender.sendMessage(MessageUtil.REMOVE);
                    Iterator itr = s.getActivePotionEffects().iterator();

                    while(itr.hasNext()) {
                        PotionEffect effect = (PotionEffect)itr.next();
                        s.removePotionEffect(effect.getType());
                    }
                    return true;
                } else {
                    sender.sendMessage(MessageUtil.PERM);
                }
            }
        }
        return true;
    }
}
