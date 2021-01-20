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

public class RegCommand implements CommandExecutor {
    HashMap<String, Long> map = new HashMap();

    int GlobalCooldown = 0;
    int RegAmmount = 0;
    int RegTime = 0;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.CONSOLE);
        } else {
            Player s;
            int i;
            long diff;
            World world;
            Location location;
            if (cmd.getName().equalsIgnoreCase("vipreg")) {
                if(sender.hasPermission("t3sl4perks.vipreg")) {
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

                        RegTime = MessageUtil.REG_TIME;
                        RegAmmount = MessageUtil.REG_AMOUNT;
                        sender.sendMessage((MessageUtil.CMDREG).replaceAll("%reg%", String.valueOf(RegAmmount)).replaceAll("%time%", String.valueOf(RegTime)));
                        s = (Player)sender;
                        s.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * RegTime, RegAmmount));
                        if (!(MessageUtil.EFFECTS == true)) {
                            sender.sendMessage(MessageUtil.REGENERATION);
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

                            sender.sendMessage(MessageUtil.REGENERATION);
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
