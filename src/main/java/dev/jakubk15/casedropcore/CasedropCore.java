package dev.jakubk15.casedropcore;

import dev.jakubk15.casedropcore.cmds.*;
import org.bukkit.plugin.java.JavaPlugin;

public class CasedropCore extends JavaPlugin {

	public static CasedropCore instance;

	@Override
	public void onEnable() {
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("ip").setExecutor(new IPCommand());
		getCommand("nick").setExecutor(new NickCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("ac").setExecutor(new AdminChatCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("banip").setExecutor(new BanIPCommand());
		getCommand("chat").setExecutor(new ChatManager());
		getCommand("helpop").setExecutor(new HelpopCommand());
		getCommand("uuid").setExecutor(new UUIDCommand());
		getCommand("god").setExecutor(new GodCommand());
		getCommand("alert").setExecutor(new AlertCommand());
		getCommand("freeze").setExecutor(new FreezeCommand());
		getCommand("reload").setExecutor(new ReloadCommand());
		getCommand("msg").setExecutor(new MsgCommand());
		getCommand("mute").setExecutor(new MuteCommand());
		getCommand("unban").setExecutor(new UnbanCommand());
		this.getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public static CasedropCore getInstance() {
		return instance;
	}
}
