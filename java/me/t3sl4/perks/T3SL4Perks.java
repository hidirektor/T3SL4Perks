package me.t3sl4.perks;

import me.t3sl4.perks.commands.*;
import me.t3sl4.perks.util.MessageUtil;
import me.t3sl4.perks.util.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class T3SL4Perks extends JavaPlugin {
    private static SettingsManager manager = SettingsManager.getInstance();

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("   ");
        Bukkit.getConsoleSender().sendMessage("  ____   __   __  _   _   _____   _____   ____    _       _  _   ");
        Bukkit.getConsoleSender().sendMessage(" / ___|  \\ \\ / / | \\ | | |_   _| |___ /  / ___|  | |     | || |  ");
        Bukkit.getConsoleSender().sendMessage(" \\___ \\   \\ V /  |  \\| |   | |     |_ \\  \\___ \\  | |     | || |_ ");
        Bukkit.getConsoleSender().sendMessage("  ___) |   | |   | |\\  |   | |    ___) |  ___) | | |___  |__   _|");
        Bukkit.getConsoleSender().sendMessage(" |____/    |_|   |_| \\_|   |_|   |____/  |____/  |_____|    |_|  ");
        Bukkit.getConsoleSender().sendMessage("    ");
        enable();
    }

    private void enable() {
        manager.setup(this);
        MessageUtil.loadMessages();
        loadCommands();
    }

    private void loadCommands() {
        getCommand("perks").setExecutor((CommandExecutor)new GeneralCommand());
        getCommand("vipair").setExecutor((CommandExecutor)new AirCommand());
        getCommand("vipdig").setExecutor((CommandExecutor)new DigCommand());
        getCommand("vipfir").setExecutor((CommandExecutor)new FireCommand());
        getCommand("vipinv").setExecutor((CommandExecutor)new InvCommand());
        getCommand("vipjmp").setExecutor((CommandExecutor)new JumpCommand());
        getCommand("vipreg").setExecutor((CommandExecutor)new RegCommand());
        getCommand("vipris").setExecutor((CommandExecutor)new RisCommand());
        getCommand("vipsee").setExecutor((CommandExecutor)new SeeCommand());
        getCommand("vipspd").setExecutor((CommandExecutor)new SpeedCommand());
        getCommand("vipstr").setExecutor((CommandExecutor)new StrengthCommand());
        getCommand("viprem").setExecutor((CommandExecutor)new RemoveCommand());
    }
}
