package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.CasedropCore;
import dev.jakubk15.casedropcore.utils.Util;
import org.mineacademy.fo.command.SimpleCommand;

public class ReloadCommand extends SimpleCommand {

	public ReloadCommand() {
		super("reload");
	}

	@Override
	public void onCommand() {
		if (sender.hasPermission("essentials.reload")) {
			CasedropCore.getInstance().reload();
			sender.sendMessage(Util.color("&3Przeładowano config!"));
		} else {
			sender.sendMessage(Util.color("&cBrak uprawnien."));
		}
	}
}
