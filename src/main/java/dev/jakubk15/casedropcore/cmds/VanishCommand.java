package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player p = (Player) sender;
		// TODO skrócić ten syf
		if (p.hasPermission("essentials.vanish")) {
			if (args[0] != null) {
				Player cel = Bukkit.getPlayerExact(args[0]);
				if (cel.isInvisible()) {
					p.sendMessage(ChatColorUtil.fixColor("&3Wyłączono vanish dla gracza &b " + p.getName()));
					cel.setInvisible(false);
				} else {
					p.sendMessage(ChatColorUtil.fixColor("&3Włączono vanish dla gracza &b " + p.getName()));
					cel.setInvisible(true);
				}
			} else {
				if (p.isInvisible()) {
					p.sendMessage(ChatColorUtil.fixColor("&3Wyłączono vanisha"));
					p.setInvisible(false);
				} else {
					p.sendMessage(ChatColorUtil.fixColor("&3Włączono vanisha"));
					p.setInvisible(true);
				}
			}
		}
		return false;
	}
}
