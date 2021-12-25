package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WorkbenchCommand implements CommandExecutor {

	public WorkbenchCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
		if (commandSender instanceof Player p) {
			if (commandSender.hasPermission("essentials.workbench")) {
				p.openWorkbench(null, true);
				return true;
			} else {
				commandSender.sendMessage(Util.color("&cBrak uprawnień."));
				return false;
			}
		} else {
			commandSender.sendMessage("Nie można wykonać tego polecenia z poziomu konsoli.");
		}
		return false;
	}
}
