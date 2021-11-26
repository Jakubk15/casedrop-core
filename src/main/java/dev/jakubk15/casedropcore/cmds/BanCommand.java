package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BanCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.ban")) {
				if (args.length() > 0) {
					final Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					//if (args.length() > 0) {
						target.banPlayer(ChatColorUtil.fixColor("&cZostałeś zbanowany!\n\nPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]));
						sender.sendMessage(ChatColorUtil.fixColor("&3Zbanowano gracza " + target.getName() + "\n&3Powód: " + args[1]));
					//} else {
						//target.banPlayer(ChatColorUtil.fixColor("&cZostałeś zbanowany!\n\nPrzez administratora: " + sender.getName()));
						//sender.sendMessage(ChatColorUtil.fixColor("&3Zbanowano gracza " + target.getName()));
					}
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
			}

	return false;
	}
}
