package dev.jakubk15.casedropcore;

import dev.jakubk15.casedropcore.cmds.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class CasedropCore extends JavaPlugin {

	public static CasedropCore instance;

	@Override
	public void onEnable() {
		instance = this;
		Objects.requireNonNull(instance.getCommand("feed")).setExecutor(new FeedCommand());
		Objects.requireNonNull(instance.getCommand("heal")).setExecutor(new HealCommand());
		Objects.requireNonNull(instance.getCommand("fly")).setExecutor(new FlyCommand());
		Objects.requireNonNull(instance.getCommand("ip")).setExecutor(new IPCommand());
		Objects.requireNonNull(instance.getCommand("nick")).setExecutor(new NickCommand());
		Objects.requireNonNull(instance.getCommand("gm")).setExecutor(new GamemodeCommand());
		Objects.requireNonNull(instance.getCommand("ping")).setExecutor(new PingCommand());
		Objects.requireNonNull(instance.getCommand("vanish")).setExecutor(new VanishCommand());
		Objects.requireNonNull(instance.getCommand("kick")).setExecutor(new KickCommand());
		Objects.requireNonNull(instance.getCommand("ac")).setExecutor(new AdminChatCommand());
		Objects.requireNonNull(instance.getCommand("ban")).setExecutor(new BanCommand());
		Objects.requireNonNull(instance.getCommand("banip")).setExecutor(new BanIPCommand());
		Objects.requireNonNull(instance.getCommand("chat")).setExecutor(new ChatManager());
		Objects.requireNonNull(instance.getCommand("helpop")).setExecutor(new HelpopCommand());
		Objects.requireNonNull(instance.getCommand("uuid")).setExecutor(new UUIDCommand());
		Objects.requireNonNull(instance.getCommand("god")).setExecutor(new GodCommand());
		Objects.requireNonNull(instance.getCommand("alert")).setExecutor(new AlertCommand());
		Objects.requireNonNull(instance.getCommand("freeze")).setExecutor(new FreezeCommand());
		Objects.requireNonNull(instance.getCommand("reload")).setExecutor(new ReloadCommand());
		Objects.requireNonNull(instance.getCommand("msg")).setExecutor(new MsgCommand());
		Objects.requireNonNull(instance.getCommand("mute")).setExecutor(new MuteCommand());
		Objects.requireNonNull(instance.getCommand("unban")).setExecutor(new UnbanCommand());
		this.getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
	}

	public static CasedropCore getInstance() {
		return instance;
	}
}
