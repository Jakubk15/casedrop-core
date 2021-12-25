package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UnbanCommand implements CommandExecutor {

	public UnbanCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.unban")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					if (target.isBanned()) {
						Bukkit.getServer().getBannedPlayers().remove(target);
						return true;
					} else {
						sender.sendMessage(Util.color("&cTen gracz nie jest zbanowany!"));
						return false;
					}
				} else {
					sender.sendMessage(Util.color("&cPodaj nick gracza!"));
					return false;
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnien!"));
			}
		return false;
	}
}
