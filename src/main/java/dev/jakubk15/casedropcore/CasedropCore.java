package dev.jakubk15.casedropcore;

import dev.jakubk15.casedropcore.cmds.*;
import org.bukkit.plugin.java.JavaPlugin;

public class CasedropCore extends JavaPlugin {

	private static CasedropCore instance;

	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("_________                  ________                            _________                  ");
		getLogger().info("__  ____/_____ _______________  __ \\____________________       __  ____/_________________ ");
		getLogger().info("_  /    _  __ `/_  ___/  _ \\_  / / /_  ___/  __ \\__  __ \\_______  /    _  __ \\_  ___/  _ \\");
		getLogger().info("/ /___  / /_/ /_(__  )/  __/  /_/ /_  /   / /_/ /_  /_/ //_____/ /___  / /_/ /  /   /  __/");
		getLogger().info("\\____/  \\__,_/ /____/ \\___//_____/ /_/    \\____/_  .___/       \\____/  \\____//_/    \\___/ ");
		getLogger().info("                                                /_/                                       ");
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
