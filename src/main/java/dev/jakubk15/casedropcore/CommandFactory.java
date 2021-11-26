package dev.jakubk15.casedropcore;

import dev.jakubk15.casedropcore.cmds.*;

public class CommandFactory {

	public void registerCommands() {
		CasedropCore.getInstance().getCommand("feed").setExecutor(new FeedCommand());
		CasedropCore.getInstance().getCommand("heal").setExecutor(new HealCommand());
		CasedropCore.getInstance().getCommand("fly").setExecutor(new FlyCommand());
		CasedropCore.getInstance().getCommand("ip").setExecutor(new IPCommand());
		CasedropCore.getInstance().getCommand("nick").setExecutor(new NickCommand());
		CasedropCore.getInstance().getCommand("gm").setExecutor(new GamemodeCommand());
		CasedropCore.getInstance().getCommand("ping").setExecutor(new PingCommand());
		CasedropCore.getInstance().getCommand("vanish").setExecutor(new VanishCommand());
		CasedropCore.getInstance().getCommand("kick").setExecutor(new KickCommand());
		CasedropCore.getInstance().getCommand("ac").setExecutor(new AdminChatCommand());
		CasedropCore.getInstance().getCommand("ban").setExecutor(new BanCommand());
		CasedropCore.getInstance().getCommand("banip").setExecutor(new BanIPCommand());
		CasedropCore.getInstance().getCommand("chat").setExecutor(new ChatManager());
		CasedropCore.getInstance().getCommand("helpop").setExecutor(new HelpopCommand());
		CasedropCore.getInstance().getCommand("uuid").setExecutor(new UUIDCommand());
		CasedropCore.getInstance().getCommand("god").setExecutor(new GodCommand());
		CasedropCore.getInstance().getCommand("alert").setExecutor(new AlertCommand());
		CasedropCore.getInstance().getCommand("freeze").setExecutor(new FreezeCommand());
		CasedropCore.getInstance().getCommand("reload").setExecutor(new ReloadCommand());
		CasedropCore.getInstance().getCommand("msg").setExecutor(new MsgCommand());
		CasedropCore.getInstance().getCommand("mute").setExecutor(new MuteCommand());
		CasedropCore.getInstance().getCommand("unban").setExecutor(new UnbanCommand());
		CasedropCore.getInstance().getCommand("grindstone").setExecutor(new GrindstoneCommand());
		CasedropCore.getInstance().getCommand("enderchest").setExecutor(new EnderChestCommand());
		CasedropCore.getInstance().getCommand("workbench").setExecutor(new WorkbenchCommand());
		CasedropCore.getInstance().getCommand("stonecutter").setExecutor(new StoneCutterCommand());
		CasedropCore.getInstance().getCommand("anvil").setExecutor(new AnvilCommand());

	}
}
