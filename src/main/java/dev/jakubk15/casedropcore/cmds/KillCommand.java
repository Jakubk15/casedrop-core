package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KillCommand implements CommandExecutor {

	public KillCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
		if (sender.hasPermission("essentials.kill")) {
			Player target = Bukkit.getPlayerExact(args[0]);
			target.setHealth(0);
			sender.sendMessage(Util.color("&3Zabito gracza &b" + target.getName()));
			return true;
		}
		return false;
	}
}
