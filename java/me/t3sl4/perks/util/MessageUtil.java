package me.t3sl4.perks.util;

import java.util.ArrayList;
import java.util.List;

public class MessageUtil {
    public static String PREFIX;
    public static List<String> DISABLED_WORLDS = new ArrayList<>();
    public static boolean DISABLE_WORLDS;
    public static String UR_IN_DISABLE_WORLD;
    public static int GLOBAL_COOLDOWN;
    public static boolean EFFECTS;
    public static int SPEED_AMOUNT;
    public static int SPEED_TIME;
    public static int JUMP_AMOUNT;
    public static int JUMP_TIME;
    public static int STRENGTH_AMOUNT;
    public static int STRENGTH_TIME;
    public static int AIR_AMOUNT;
    public static int AIR_TIME;
    public static int FIRE_AMOUNT;
    public static int FIRE_TIME;
    public static int DIG_AMOUNT;
    public static int DIG_TIME;
    public static int RIS_AMOUNT;
    public static int RIS_TIME;
    public static int REG_AMOUNT;
    public static int REG_TIME;
    public static int INV_TIME;
    public static int SEE_TIME;
    public static String CONSOLE;
    public static String REMOVE;
    public static String AIR;
    public static String DIG;
    public static String FIRE_RESISTANCE;
    public static String INVISIBILITY;
    public static String JUMP;
    public static String REGENERATION;
    public static String RESISTANCE;
    public static String NIGHT_VISION;
    public static String SPEED;
    public static String STRENGTH;
    public static String COOLDOWN;
    public static String CMDSTR;
    public static String CMDSPD;
    public static String CMDSEE;
    public static String CMDRIS;
    public static String CMDREG;
    public static String CMDJMP;
    public static String CMDINV;
    public static String CMDFIR;
    public static String CMDDIG;
    public static String CMDAIR;
    public static List<String> INFO = new ArrayList<>();
    public static String RELOAD;
    public static String PERM;
    public static String AVAILABLE;
    public static String AIRINFO;
    public static String DIGINFO;
    public static String FIREINFO;
    public static String INVINFO;
    public static String JUMPINFO;
    public static String REGINFO;
    public static String RISINFO;
    public static String SEEINFO;
    public static String SPEEDINFO;
    public static String STRENGTHINFO;

    static SettingsManager manager = SettingsManager.getInstance();

    public static void loadMessages() {
        PREFIX = colorize(manager.getConfig().getString("Prefix"));
        DISABLED_WORLDS = manager.getConfig().getStringList("General-Settings.disabled-worlds");
        DISABLE_WORLDS = manager.getConfig().getBoolean("General-Settings.disable-worlds");
        UR_IN_DISABLE_WORLD = PREFIX + colorize(manager.getConfig().getString("Messages.Ur_in_disable_world"));
        GLOBAL_COOLDOWN = manager.getConfig().getInt("Settings.GlobalCooldown");
        EFFECTS = manager.getConfig().getBoolean("General-Settings.Effects");
        SPEED_AMOUNT = manager.getConfig().getInt("Settings.SpeedAmmount");
        SPEED_TIME = manager.getConfig().getInt("Settings.SpeedTime");
        JUMP_AMOUNT = manager.getConfig().getInt("Settings.JumpAmmount");
        JUMP_TIME = manager.getConfig().getInt("Settings.JumpTime");
        STRENGTH_AMOUNT = manager.getConfig().getInt("Settings.StrengthAmmount");
        STRENGTH_TIME = manager.getConfig().getInt("Settings.StrengthTime");
        AIR_AMOUNT = manager.getConfig().getInt("Settings.AirAmmount");
        AIR_TIME = manager.getConfig().getInt("Settings.AirTime");
        FIRE_AMOUNT = manager.getConfig().getInt("Settings.FireAmmount");
        FIRE_TIME = manager.getConfig().getInt("Settings.FireTime");
        DIG_AMOUNT = manager.getConfig().getInt("Settings.DigAmmount");
        DIG_TIME = manager.getConfig().getInt("Settings.DigTime");
        RIS_AMOUNT = manager.getConfig().getInt("Settings.RisAmmount");
        RIS_TIME = manager.getConfig().getInt("Settings.RisTime");
        REG_AMOUNT = manager.getConfig().getInt("Settings.RegAmmount");
        REG_TIME = manager.getConfig().getInt("Settings.RegTime");
        INV_TIME = manager.getConfig().getInt("Settings.InvTime");
        SEE_TIME = manager.getConfig().getInt("Settings.SeeTime");
        CONSOLE = PREFIX + colorize(manager.getConfig().getString("Messages.Console"));
        REMOVE = PREFIX + colorize(manager.getConfig().getString("Messages.Remove"));
        AIR = PREFIX + colorize(manager.getConfig().getString("Messages.Air"));
        DIG = PREFIX + colorize(manager.getConfig().getString("Messages.Dig"));
        FIRE_RESISTANCE = PREFIX + colorize(manager.getConfig().getString("Messages.FireResistance"));
        INVISIBILITY = PREFIX + colorize(manager.getConfig().getString("Messages.Invisibility"));
        JUMP = PREFIX + colorize(manager.getConfig().getString("Messages.Jump"));
        REGENERATION = PREFIX + colorize(manager.getConfig().getString("Messages.Regeneration"));
        RESISTANCE = PREFIX + colorize(manager.getConfig().getString("Messages.Resistance"));
        NIGHT_VISION = PREFIX + colorize(manager.getConfig().getString("Messages.NightVision"));
        SPEED = PREFIX + colorize(manager.getConfig().getString("Messages.Speed"));
        STRENGTH = PREFIX + colorize(manager.getConfig().getString("Messages.Strength"));
        COOLDOWN = PREFIX + colorize(manager.getConfig().getString("Messages.Cooldown"));
        CMDSTR = PREFIX + colorize(manager.getConfig().getString("Messages.CmdStr"));
        CMDSPD = PREFIX + colorize(manager.getConfig().getString("Messages.CmdSpd"));
        CMDSEE = PREFIX + colorize(manager.getConfig().getString("Messages.CmdSee"));
        CMDRIS = PREFIX + colorize(manager.getConfig().getString("Messages.CmdRis"));
        CMDREG = PREFIX + colorize(manager.getConfig().getString("Messages.CmdReg"));
        CMDJMP = PREFIX + colorize(manager.getConfig().getString("Messages.CmdJmp"));
        CMDINV = PREFIX + colorize(manager.getConfig().getString("Messages.CmdInv"));
        CMDFIR = PREFIX + colorize(manager.getConfig().getString("Messages.CmdFir"));
        CMDDIG = PREFIX + colorize(manager.getConfig().getString("Messages.CmdDig"));
        CMDAIR = PREFIX + colorize(manager.getConfig().getString("Messages.CmdAir"));
        INFO = colorizeList(manager.getConfig().getStringList("Info.Commands"));
        RELOAD = PREFIX + colorize(manager.getConfig().getString("Messages.Reload"));
        PERM = PREFIX + colorize(manager.getConfig().getString("Messages.Perm"));
        AVAILABLE = colorize(manager.getConfig().getString("Info.Effects.available"));
        AIRINFO = colorize(manager.getConfig().getString("Info.Effects.air"));
        DIGINFO = colorize(manager.getConfig().getString("Info.Effects.dig"));
        FIREINFO = colorize(manager.getConfig().getString("Info.Effects.fire"));
        INVINFO = colorize(manager.getConfig().getString("Info.Effects.inv"));
        JUMPINFO = colorize(manager.getConfig().getString("Info.Effects.jump"));
        REGINFO = colorize(manager.getConfig().getString("Info.Effects.reg"));
        RISINFO = colorize(manager.getConfig().getString("Info.Effects.ris"));
        SEEINFO = colorize(manager.getConfig().getString("Info.Effects.see"));
        SPEEDINFO = colorize(manager.getConfig().getString("Info.Effects.speed"));
        STRENGTHINFO = colorize(manager.getConfig().getString("Info.Effects.strength"));
    }

    public static String colorize(String str) {
        return str.replace("&", "§");
    }

    public static List<String> colorizeList(List<String> str) {
        for(int x=0; x<str.size(); x++) {
            str.set(x, str.get(x).replace("&", "§"));
        }
        return str;
    }
}