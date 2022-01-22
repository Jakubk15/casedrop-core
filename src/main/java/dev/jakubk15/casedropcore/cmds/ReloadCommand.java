package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.CasedropCore;
import dev.jakubk15.casedropcore.utils.Util;
import org.mineacademy.fo.command.SimpleCommand;

public class ReloadCommand extends SimpleCommand {

	public ReloadCommand() {
		super("casedropcore-reload");
		setPermission("essentials.reload");
		setDescription("Reloads the plugin.");
	}

	@Override
	public void onCommand() {
		CasedropCore.getInstance().reload();
		sender.sendMessage(Util.color("&3Przeładowano config!"));
	}
}
