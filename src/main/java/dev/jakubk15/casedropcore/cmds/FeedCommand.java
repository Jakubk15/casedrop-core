package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player p) {
			if (p.hasPermission("essentials.feed")) {
				if (args[0].length() >= 1) {
					Player cel = Bukkit.getPlayerExact(args[0]);
					assert cel != null;
					cel.setFoodLevel(20);
					cel.sendMessage(ChatColorUtil.fixColor("&3Zostałeś najedzony!"));
					p.sendMessage(ChatColorUtil.fixColor("&3Najadłeś gracza " + cel.getName() + "."));
				} else {
					p.setFoodLevel(20);
					p.sendMessage(ChatColorUtil.fixColor("&3Zostałeś najedzony!"));
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
			}
		} else if (sender instanceof ConsoleCommandSender p) {
			if (p.hasPermission("essentials.feed")) {
				if (args[0].length() >= 1) {
					Player cel = Bukkit.getPlayerExact(args[0]);
					assert cel != null;
					cel.setFoodLevel(20);
					cel.sendMessage(ChatColorUtil.fixColor("&3Zostałeś najedzony!"));
					p.sendMessage(ChatColorUtil.fixColor("&3Najadłeś gracza " + cel.getName() + "."));
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
			}
		}
	}
	return false;
	}
}
