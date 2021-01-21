package me.t3sl4.perks.commands;

import me.t3sl4.perks.util.MessageUtil;
import me.t3sl4.perks.util.XSound;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.HashMap;

public class FireCommand implements CommandExecutor {
    HashMap<String, Long> map = new HashMap();
    Sound dragon = XSound.ENTITY_ENDER_DRAGON_GROWL.parseSound();

    int GlobalCooldown = 0;
    int FireAmmount = 0;
    int FireTime = 0;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.CONSOLE);
        } else {
            Player s;
            int i;
            long diff;
            World world;
            Location location;
            if (cmd.getName().equalsIgnoreCase("vipfir")) {
                if(sender.hasPermission("t3sl4perks.vipfir")) {
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

                        FireAmmount = MessageUtil.FIRE_AMOUNT;
                        FireTime = MessageUtil.FIRE_TIME;
                        sender.sendMessage((MessageUtil.CMDFIR).replaceAll("%fir%", String.valueOf(FireAmmount)).replaceAll("%time%", String.valueOf(FireTime)));
                        s = (Player)sender;
                        s.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * FireTime, FireAmmount));
                        if (!(MessageUtil.EFFECTS == true)) {
                            sender.sendMessage(MessageUtil.FIRE_RESISTANCE);
                            this.map.put(sender.getName(), System.currentTimeMillis());
                            return true;
                        } else {
                            world = s.getWorld();
                            location = s.getLocation();
                            world.strikeLightningEffect(location);
                            s.getWorld().playSound(location, dragon, Float.MAX_VALUE, 1.17549435E-38F);

                            for(i = 0; i <= 8; ++i) {
                                s.getWorld().playEffect(s.getLocation(), Effect.SMOKE, i);
                            }

                            for(i = 0; i <= 8; ++i) {
                                s.getWorld().playEffect(s.getLocation(), Effect.MOBSPAWNER_FLAMES, i);
                            }

                            for(i = 0; i <= 8; ++i) {
                                s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
                            }

                            sender.sendMessage(MessageUtil.FIRE_RESISTANCE);
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
