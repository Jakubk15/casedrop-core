package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UnmuteCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.unmute")) {
				if (args[0].length() >= 1) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					if (MuteCommand.muted.contains(target.getUniqueId())) {
						MuteCommand.muted.remove(target.getUniqueId());
						sender.sendMessage(ChatColorUtil.fixColor("&3Odciszono gracza " + target.getName()));
					} else {
						sender.sendMessage(ChatColorUtil.fixColor("&cTen gracz nie jest wyciszony!"));
					}
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
			}

		return false;
	}
}
