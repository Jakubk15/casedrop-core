package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class WorkbenchCommand extends SimpleCommand {

	public WorkbenchCommand() {
		super("wb|workbench");
	}

	@Override
	public void onCommand() {
		if (sender instanceof Player p) {
			if (sender.hasPermission("essentials.workbench")) {
				p.openWorkbench(null, true);
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień."));
			}
		} else {
			sender.sendMessage("Nie można wykonać tego polecenia z poziomu konsoli.");
		}
	}
}
