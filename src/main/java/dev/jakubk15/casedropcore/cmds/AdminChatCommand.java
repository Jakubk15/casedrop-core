package dev.jakubk15.casedropcore.cmds;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public class AdminChatCommand extends SimpleCommand {

	public AdminChatCommand() {
		super("adminchat|ac");
		setMinArguments(1);
		setUsage("<message>");
		setDescription("Sends message to all admins online.");
		setPermission("essentials.adminchat");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		Common.broadcastWithPerm("msky.adminchat", "&3┃ &9&lMODCHAT &3┃ &6" + getPlayer().getName() + " &8» &3" + Common.joinRange(0, args), false);
	}


	@Override
	protected List<String> completeLastWordPlayerNames() {
		return super.completeLastWordPlayerNames();
	}
}

