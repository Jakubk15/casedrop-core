package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NickCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.nick")) {
				if (args[0].length() >= 1) {
					if (args[1].length() >= 1) {
						Player cel = Bukkit.getPlayerExact(args[1]);
						assert cel != null;
						cel.setDisplayName(args[0]);
						sender.sendMessage(ChatColorUtil.fixColor("&3Zmieniono nick gracza " + cel.getName() + " na " + args[0]));
					} else {
						Player sender1 = (Player) sender;
						sender1.setDisplayName(args[0]);
						sender.sendMessage(ChatColorUtil.fixColor("&3Zmieniłeś swoją nazwę użytkownika na " + args[0]));
					}
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj nowy nick!"));
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
			}

		return false;
	}
}
