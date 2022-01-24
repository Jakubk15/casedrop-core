package dev.jakubk15.casedropcore.cmds;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class WorkbenchCommand extends SimpleCommand {

	public WorkbenchCommand() {
		super("wb|workbench");
		setPermission("essentials.workbench");
		setDescription("Opens a workbench.");
	}

	@Override
	public void onCommand() {
		checkConsole();
		if (sender.hasPermission("essentials.workbench")) {
			((Player) sender).openWorkbench(null, true);
		} else {
			sender.sendMessage("Nie można wykonać tego polecenia z poziomu konsoli.");
		}
	}
}
