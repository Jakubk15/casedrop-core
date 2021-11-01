package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UnbanCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player p) {
			if (p.hasPermission("essentials.unban")) {
				if (args[0].length() >= 1) {
					Player cel = Bukkit.getPlayerExact(args[0]);
					assert cel != null;
					if (cel.isBanned()) {
						Bukkit.getServer().getBannedPlayers().remove(cel);
					} else {
						p.sendMessage(ChatColorUtil.fixColor("&cTen gracz nie jest zbanowany!"));
					}
				} else {
					p.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
			}
		} else if (sender instanceof ConsoleCommandSender p) {
			if (p.hasPermission("essentials.unban")) {
				if (args[0].length() >= 1) {
					Player cel = Bukkit.getPlayerExact(args[0]);
					assert cel != null;
					if (cel.isBanned()) {
						Bukkit.getServer().getBannedPlayers().remove(cel);
					} else {
						p.sendMessage(ChatColorUtil.fixColor("&cTen gracz nie jest zbanowany!"));
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
