package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.CasedropCore;
import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

	public ReloadCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender.hasPermission("essentials.reload")) {
			CasedropCore.getInstance().reloadConfig();
			sender.sendMessage(Util.color("&3Przeładowano config!"));
			return true;
		} else {
			sender.sendMessage(Util.color("&cBrak uprawnien."));
		}
		return false;
	}
}
