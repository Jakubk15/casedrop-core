package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.CasedropCore;
import dev.jakubk15.casedropcore.utils.Util;
import org.mineacademy.fo.command.SimpleCommand;

public class ReloadCommand extends SimpleCommand {

	public ReloadCommand() {
		super("casedropcore-reload");
		setPermission("essentials.reload");
		setDescription("Reloads the plugin.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		try {
			CasedropCore.getInstance().reload();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sender.sendMessage(Util.color("&3Przeładowano config!"));
		}
	}
}
