package dev.jakubk15.casedropcore;

import org.bukkit.plugin.java.JavaPlugin;

public class CasedropCore extends JavaPlugin {

	public CasedropCore() {
	}

	public static CasedropCore instance;
	private CommandFactory commandFactory;

	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("_________                  ________                            _________                  ");
		getLogger().info("__  ____/_____ _______________  __ \\____________________       __  ____/_________________ ");
		getLogger().info("_  /    _  __ `/_  ___/  _ \\_  / / /_  ___/  __ \\__  __ \\_______  /    _  __ \\_  ___/  _ \\");
		getLogger().info("/ /___  / /_/ /_(__  )/  __/  /_/ /_  /   / /_/ /_  /_/ //_____/ /___  / /_/ /  /   /  __/");
		getLogger().info("\\____/  \\__,_/ /____/ \\___//_____/ /_/    \\____/_  .___/       \\____/  \\____//_/    \\___/ ");
		getLogger().info("                                                /_/                                       ");
		commandFactory.registerCommands();
		this.getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}

	public static CasedropCore getInstance() {
		return instance;
	}
}
