package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player p) {
			if (p.hasPermission("essentials.god")) {
				if (args[0].length() >= 1) {
					Player cel = Bukkit.getPlayerExact(args[0]);
					assert cel != null;
					cel.setInvulnerable(!cel.isInvulnerable());
					p.sendMessage(ChatColorUtil.fixColor("&3Godmode " + (cel.isInvulnerable() ? "&3włączone" : "&3wyłączone")));
				} else {
					p.setInvulnerable(!p.isInvulnerable());
					p.sendMessage(ChatColorUtil.fixColor("&3Godmode " + (p.isInvulnerable() ? "&3włączone" : "&3wyłączone")));
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien."));
			}
		} else if (sender instanceof ConsoleCommandSender p) {
			if (p.hasPermission("essentials.god")) {
				if (args[0].length() >= 1) {
					Player cel = Bukkit.getPlayerExact(args[0]);
					assert cel != null;
					cel.setInvulnerable(!cel.isInvulnerable());
					p.sendMessage(ChatColorUtil.fixColor("&3Godmode " + (cel.isInvulnerable() ? "&3włączone" : "&3wyłączone")));
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien."));
			}
		}
	}
	return false;
	}
}
