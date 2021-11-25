package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BanIPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.banip")) {
				if (args[0].length() >= 1) {
					final Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					if (args[1].length() >= 1) {
						target.banPlayerFull(ChatColorUtil.fixColor("&cZostałeś zbanowany na IP!\n\nPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]));
						sender.sendMessage(ChatColorUtil.fixColor("&3Zbanowano gracza " + target.getName() + "\n&3Powód: " + args[1]));
					} else {
						target.banPlayerFull(ChatColorUtil.fixColor("&cZostałeś zbanowany na IP!\n\nPrzez administratora: " + sender.getName()));
						sender.sendMessage(ChatColorUtil.fixColor("&3Zbanowano gracza (IP) " + target.getName()));
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
