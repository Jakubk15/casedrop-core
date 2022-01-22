package dev.jakubk15.casedropcore;

import org.mineacademy.fo.plugin.SimplePlugin;

public class CasedropCore extends SimplePlugin {

	public CasedropCore() {}

	public static CasedropCore instance;

	@Override
	public void onPluginStart() {
		instance = this;
		getLogger().info("_________                  ________                            _________                  ");
		getLogger().info("__  ____/_____ _______________  __ \\____________________       __  ____/_________________ ");
		getLogger().info("_  /    _  __ `/_  ___/  _ \\_  / / /_  ___/  __ \\__  __ \\_______  /    _  __ \\_  ___/  _ \\");
		getLogger().info("/ /___  / /_/ /_(__  )/  __/  /_/ /_  /   / /_/ /_  /_/ //_____/ /___  / /_/ /  /   /  __/");
		getLogger().info("\\____/  \\__,_/ /____/ \\___//_____/ /_/    \\____/_  .___/       \\____/  \\____//_/    \\___/ ");
		getLogger().info("                                                /_/                                       ");
		registerCommands();
	}

	public static CasedropCore getInstance() {
		return (CasedropCore) SimplePlugin.getInstance();
	}

	public void registerCommands() {

	}


}
