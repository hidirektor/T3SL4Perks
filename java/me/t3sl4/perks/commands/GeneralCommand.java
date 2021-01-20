package me.t3sl4.perks.commands;

import me.t3sl4.perks.util.MessageUtil;
import me.t3sl4.perks.util.SettingsManager;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GeneralCommand implements CommandExecutor {
    private SettingsManager manager = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        TextComponent msg = new TextComponent("§e§lAuthor §7|| §e§lYapımcı");
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("§7Eklenti Yapımcısı:\n   §8§l» §eSYN_T3SL4 \n   §8§l» §7Discord: §eHalil#4439")).create()));
        Player hover = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("perks")) {
            if(args.length == 0) {
                if(sender.isOp() || sender.hasPermission("t3sl4perms.general")) {
                    sender.sendMessage(String.valueOf(MessageUtil.INFO));
                    hover.spigot().sendMessage(msg);
                } else {
                    sender.sendMessage(String.valueOf(MessageUtil.INFO));
                }
            } else if(args[0].equalsIgnoreCase("list")) {
                sender.sendMessage(MessageUtil.AVAILABLE);
                sender.sendMessage((MessageUtil.AIRINFO).replaceAll("%air%", String.valueOf(MessageUtil.AIR_AMOUNT)).replaceAll("%time%", String.valueOf(MessageUtil.AIR_TIME)));
                sender.sendMessage((MessageUtil.DIGINFO).replaceAll("%dig%", String.valueOf(MessageUtil.DIG_AMOUNT)).replaceAll("%time%", String.valueOf(MessageUtil.DIG_TIME)));
                sender.sendMessage((MessageUtil.FIREINFO).replaceAll("%fire%", String.valueOf(MessageUtil.FIRE_AMOUNT)).replaceAll("%time%", String.valueOf(MessageUtil.FIRE_TIME)));
                sender.sendMessage((MessageUtil.INVINFO).replaceAll("%time%", String.valueOf(MessageUtil.INV_TIME)));
                sender.sendMessage((MessageUtil.JUMPINFO).replaceAll("%jmp%", String.valueOf(MessageUtil.JUMP_AMOUNT)).replaceAll("%time%", String.valueOf(MessageUtil.JUMP_TIME)));
                sender.sendMessage((MessageUtil.REGINFO).replaceAll("%reg%", String.valueOf(MessageUtil.REG_AMOUNT)).replaceAll("%time%", String.valueOf(MessageUtil.REG_TIME)));
                sender.sendMessage((MessageUtil.RISINFO).replaceAll("%ris%", String.valueOf(MessageUtil.RIS_AMOUNT)).replaceAll("%time%", String.valueOf(MessageUtil.RIS_TIME)));
                sender.sendMessage((MessageUtil.SEEINFO).replaceAll("%time%", String.valueOf(MessageUtil.SEE_TIME)));
                sender.sendMessage((MessageUtil.SPEEDINFO).replaceAll("%spd%", String.valueOf(MessageUtil.SPEED_AMOUNT)).replaceAll("%time%", String.valueOf(MessageUtil.SPEED_TIME)));
                sender.sendMessage((MessageUtil.STRENGTHINFO).replaceAll("%str%", String.valueOf(MessageUtil.STRENGTH_AMOUNT)).replaceAll("%time%", String.valueOf(MessageUtil.STRENGTH_TIME)));
            } else if(args[0].equalsIgnoreCase("reload")) {
                manager.reloadConfig();
                sender.sendMessage(MessageUtil.RELOAD);
            } else if(args[0].equalsIgnoreCase("info")) {
                hover.spigot().sendMessage(msg);
            }
        }
        return true;
    }
}
