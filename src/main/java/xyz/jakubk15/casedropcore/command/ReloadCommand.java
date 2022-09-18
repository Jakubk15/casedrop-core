package xyz.jakubk15.casedropcore.command;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;
import xyz.jakubk15.casedropcore.CasedropCore;

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
			sender.sendMessage(Common.colorize(Lang.of("Commands.Reload_Success")));
		}
	}
}
