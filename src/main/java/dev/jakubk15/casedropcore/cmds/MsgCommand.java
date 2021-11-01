package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MsgCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.msg")) {
				if (args[0].length() >= 1) {
					if (args[1].length() >= 1) {
						Player cel = Bukkit.getPlayerExact(args[0]);
						assert cel != null;
						String msg = args[1];
						cel.sendMessage(ChatColorUtil.fixColor("&3[&b" + sender.getName() + "&3 -> " + cel.getName() + "&3] &7" + msg));
						sender.sendMessage(ChatColorUtil.fixColor("&3[&b" + sender.getName() + "&3 -> " + cel.getName() + "&3] &7" + msg));
					} else {
						sender.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
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
