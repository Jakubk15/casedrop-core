package dev.jakubk15.casedropcore;

import dev.jakubk15.casedropcore.cmds.*;
import org.mineacademy.fo.plugin.SimplePlugin;

public class CasedropCore extends SimplePlugin {

	public CasedropCore() {
	}

	public static CasedropCore instance;

	@Override
	public void onPluginStart() {
		// Our beautiful title :)
		getLogger().info("_________                  ________                            _________                  ");
		getLogger().info("__  ____/_____ _______________  __ \\____________________       __  ____/_________________ ");
		getLogger().info("_  /    _  __ `/_  ___/  _ \\_  / / /_  ___/  __ \\__  __ \\_______  /    _  __ \\_  ___/  _ \\");
		getLogger().info("/ /___  / /_/ /_(__  )/  __/  /_/ /_  /   / /_/ /_  /_/ //_____/ /___  / /_/ /  /   /  __/");
		getLogger().info("\\____/  \\__,_/ /____/ \\___//_____/ /_/    \\____/_  .___/       \\____/  \\____//_/    \\___/ ");
		getLogger().info("                                                /_/                                       ");
		// Register commands + events
		registerCommands();
		registerEvents();
	}

	public static CasedropCore getInstance() {
		return (CasedropCore) SimplePlugin.getInstance();
	}

	/* TODO:
	- realnickname command
	- socialspy (finish config check)
	- messages.properties
	- settings.yml
    - split ChatManager and FreezeCommand onto listeners
	 */


	public void registerCommands() {
		registerCommand(new AdminChatCommand());
		registerCommand(new AlertCommand());
		registerCommand(new AnvilCommand());
		registerCommand(new BanCommand());
		registerCommand(new BanIPCommand());
		registerCommand(new ChatManager());
		registerCommand(new CheckbanCommand());
		registerCommand(new EnderChestCommand());
		registerCommand(new FeedCommand());
		registerCommand(new FlyCommand());
		registerCommand(new FreezeCommand());
		registerCommand(new GamemodeCommand());
		registerCommand(new GodCommand());
		registerCommand(new GrindstoneCommand());
		registerCommand(new HealCommand());
		registerCommand(new HelpopCommand());
		registerCommand(new IPCommand());
		registerCommand(new KickCommand());
		registerCommand(new KillCommand());
		registerCommand(new MsgCommand());
		registerCommand(new MuteCommand());
		registerCommand(new NickCommand());
		registerCommand(new PingCommand());
		registerCommand(new ReloadCommand());
		registerCommand(new StoneCutterCommand());
		registerCommand(new TeleportCommand());
		registerCommand(new UnbanCommand());
		registerCommand(new UnmuteCommand());
		registerCommand(new UUIDCommand());
		registerCommand(new VanishCommand());
		registerCommand(new WorkbenchCommand());
	}

	public void registerEvents() {
		registerEvents(new ChatManager());
		registerEvents(new FreezeCommand());
		registerEvents(new MuteCommand());
	}
}
