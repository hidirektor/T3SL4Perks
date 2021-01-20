package me.t3sl4.perks.commands;

import me.t3sl4.perks.util.MessageUtil;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.HashMap;

public class DigCommand implements CommandExecutor {
    HashMap<String, Long> map = new HashMap();

    int GlobalCooldown = 0;
    int DigAmmount = 0;
    int DigTime = 0;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.CONSOLE);
        } else {
            Player s;
            int i;
            long diff;
            World world;
            Location location;
            if (cmd.getName().equalsIgnoreCase("vipdig")) {
                if(sender.hasPermission("t3sl4perks.vipdig")) {
                    if(MessageUtil.DISABLE_WORLDS == true && MessageUtil.DISABLED_WORLDS.contains(((Player) sender).getWorld().getName())) {
                        sender.sendMessage(MessageUtil.UR_IN_DISABLE_WORLD);
                    } else {
                        if (this.map.containsKey(sender.getName())) {
                            diff = (System.currentTimeMillis() - (Long)this.map.get(sender.getName())) / 1000L / 60L;
                            GlobalCooldown = MessageUtil.GLOBAL_COOLDOWN;
                            if (diff < (long)GlobalCooldown) {
                                sender.sendMessage(MessageUtil.COOLDOWN.replaceAll("%cooldown%", String.valueOf(((long)GlobalCooldown - diff))));
                                return true;
                            }
                        }

                        DigTime = MessageUtil.DIG_TIME;
                        DigAmmount = MessageUtil.DIG_AMOUNT;
                        sender.sendMessage((MessageUtil.CMDDIG).replaceAll("%dig%", String.valueOf(DigAmmount)).replaceAll("%time%", String.valueOf(DigTime)));
                        s = (Player)sender;
                        s.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * DigTime, DigAmmount));
                        if (!(MessageUtil.EFFECTS == true)) {
                            sender.sendMessage(MessageUtil.DIG);
                            this.map.put(sender.getName(), System.currentTimeMillis());
                            return true;
                        } else {
                            world = s.getWorld();
                            location = s.getLocation();
                            world.strikeLightningEffect(location);
                            s.getWorld().playSound(location, Sound.ENDERDRAGON_GROWL, Float.MAX_VALUE, 1.17549435E-38F);

                            for(i = 0; i <= 8; ++i) {
                                s.getWorld().playEffect(s.getLocation(), Effect.SMOKE, i);
                            }

                            for(i = 0; i <= 8; ++i) {
                                s.getWorld().playEffect(s.getLocation(), Effect.MOBSPAWNER_FLAMES, i);
                            }

                            for(i = 0; i <= 8; ++i) {
                                s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
                            }

                            sender.sendMessage(MessageUtil.DIG);
                            this.map.put(sender.getName(), System.currentTimeMillis());
                            return true;
                        }
                    }
                } else {
                    sender.sendMessage(MessageUtil.PERM);
                }
            }
        }
        return true;
    }
}
