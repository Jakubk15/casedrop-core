package xyz.jakubk15.casedropcore.command;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class WorkbenchCommand extends SimpleCommand {

	public WorkbenchCommand() {
		super("wb|workbench");
		setPermission("essentials.workbench");
		setDescription("Opens a workbench.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkConsole();
		((Player) sender).openWorkbench(null, true);
	}
}
