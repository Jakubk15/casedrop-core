package xyz.jakubk15.casedropcore;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.DebugCommand;
import org.mineacademy.fo.command.PermsCommand;
import org.mineacademy.fo.constants.FoPermissions;
import org.mineacademy.fo.plugin.SimplePlugin;
import xyz.jakubk15.casedropcore.cmds.*;

public class CasedropCore extends SimplePlugin {

	public CasedropCore() {
	}

	@Override
	public void onPluginStart() {
		Common.setLogPrefix("[CaseDropCore]");
		Common.log("_________                  ________                            _________                  ");
		Common.log("__  ____/_____ _______________  __ \\____________________       __  ____/_________________ ");
		Common.log("_  /    _  __ `/_  ___/  _ \\_  / / /_  ___/  __ \\__  __ \\_______  /    _  __ \\_  ___/  _ \\");
		Common.log("/ /___  / /_/ /_(__  )/  __/  /_/ /_  /   / /_/ /_  /_/ //_____/ /___  / /_/ /  /   /  __/");
		Common.log("\\____/  \\__,_/ /____/ \\___//_____/ /_/    \\____/_  .___/       \\____/  \\____//_/    \\___/ ");
		Common.log("                                                /_/                                       ");
		registerCommands();
		registerEvents();
	}

	@Override
	public int getFoundedYear() {
		return 2022;
	}
	
	public static CasedropCore getInstance() {
		return (CasedropCore) SimplePlugin.getInstance();
	}

	public void registerCommands() {
		registerCommand(new AdminChatCommand());
		registerCommand(new AlertCommand());
		registerCommand(new AnvilCommand());
		registerCommand(new BanCommand());
		registerCommand(new BanIPCommand());
		registerCommand(new ChatManager());
		registerCommand(new CheckbanCommand());
		registerCommand(new DebugCommand());
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
		registerCommand(new PermsCommand(FoPermissions.class));
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
