package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IPCommand implements CommandExecutor {

	public IPCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.ip")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					sender.sendMessage(Util.color("&3IP gracza &b") + target.getName() + " &3to &b" + target.getAddress());
					return true;
				} else {
					sender.sendMessage(Util.color("&cPodaj nick gracza!"));
					return false;
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
			}
		return false;
	}
}
