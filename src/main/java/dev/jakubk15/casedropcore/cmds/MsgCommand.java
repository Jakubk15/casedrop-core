package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MsgCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("essentials.msg")) {
				if (args[0].length() >= 1) {
					if (args[1].length() >= 1) {
						Player cel = Bukkit.getPlayerExact(args[0]);
						assert cel != null;
						String msg = args[1];
						cel.sendMessage(ChatColorUtil.fixColor("&3[&b" + p.getName() + "&3 -> " + cel.getName() + "&3] &7" + msg));
						p.sendMessage(ChatColorUtil.fixColor("&3[&b" + p.getName() + "&3 -> " + cel.getName() + "&3] &7" + msg));
					} else {
						p.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
					}
				} else {
					p.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
			}
		} else if (sender instanceof ConsoleCommandSender) {
			ConsoleCommandSender p = (ConsoleCommandSender) sender;
			if (p.hasPermission("essentials.msg")) {
				if (args[0].length() >= 1) {
					if (args[1].length() >= 1) {
						Player cel = Bukkit.getPlayerExact(args[0]);
						assert cel != null;
						String msg = args[1];
						cel.sendMessage(ChatColorUtil.fixColor("&3[&b" + p.getName() + "&3 -> " + cel.getName() + "&3] &7" + msg));
						p.sendMessage(ChatColorUtil.fixColor("&3[&b" + p.getName() + "&3 -> " + cel.getName() + "&3] &7" + msg));
					} else {
						p.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
					}
				} else {
					p.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
			}
		}
		return false;
	}
}
