package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IPCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.ip")) {
				if (args[0].length() >= 1) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					sender.sendMessage(ChatColorUtil.fixColor("&3IP gracza &b") + target.getName() + " &3to &b" + target.getAddress());
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
			}
		return false;
	}
}
