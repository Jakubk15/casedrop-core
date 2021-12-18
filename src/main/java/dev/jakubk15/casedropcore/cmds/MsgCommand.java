package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MsgCommand implements CommandExecutor {

	public MsgCommand() {
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.msg")) {
				if (args.length > 0) {
						Player target = Bukkit.getPlayerExact(args[0]);
						assert target != null;
						String msg = args[1];
						target.sendMessage(ChatColorUtil.fixColor("&3[&b" + sender.getName() + "&3 -> " + target.getName() + "&3] &7" + msg));
						sender.sendMessage(ChatColorUtil.fixColor("&3[&b" + sender.getName() + "&3 -> " + target.getName() + "&3] &7" + msg));
						return true;
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
					return false;
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
			}
		return false;
	}
}
