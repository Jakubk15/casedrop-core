package xyz.jakubk15.casedropcore;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.DebugCommand;
import org.mineacademy.fo.plugin.SimplePlugin;
import xyz.jakubk15.casedropcore.command.*;

import java.util.stream.Stream;

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
		Stream.of(
				new AdminChatCommand(),
				new AlertCommand(),
				new AnvilCommand(),
				new BanCommand(),
				new BanIPCommand(),
				new ChatManager(),
				new CheckbanCommand(),
				new DebugCommand(),
				new EnderChestCommand(),
				new FeedCommand(),
				new FlyCommand(),
				new FreezeCommand(),
				new GamemodeCommand(),
				new GodCommand(),
				new GrindstoneCommand(),
				new HealCommand(),
				new HelpopCommand(),
				new IPCommand(),
				new KickCommand(),
				new KillCommand(),
				new MsgCommand(),
				new MuteCommand(),
				new NickCommand(),
				new PingCommand(),
				new ReloadCommand(),
				new StoneCutterCommand(),
				new TeleportCommand(),
				new UnbanCommand(),
				new UnmuteCommand(),
				new UUIDCommand(),
				new VanishCommand(),
				new WorkbenchCommand()
		).forEach(command -> registerCommand(command));
	}


	public void registerEvents() {
		Stream.of(
				new ChatManager(),
				new FreezeCommand(),
				new MuteCommand()
		).forEach(event -> registerEvents(event));
	} //mute freeze chat
}
