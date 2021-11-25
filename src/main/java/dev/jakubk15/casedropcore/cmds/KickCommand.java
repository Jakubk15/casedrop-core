package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerKickEvent;
import org.jetbrains.annotations.NotNull;

public class KickCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.kick")) {
				if (args[0].length() >= 1) {
					Player cel = Bukkit.getPlayerExact(args[0]);
					assert cel != null;
					if (args[1].length() >= 1) {
						cel.kick(null, PlayerKickEvent.Cause.valueOf(ChatColorUtil.fixColor("&cZostałeś wyrzucony z serwera!\n\n&cPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1])));
					} else {
						cel.kick(null, PlayerKickEvent.Cause.valueOf(ChatColorUtil.fixColor("&cZostałeś wyrzucony z serwera!\n\n&cPrzez administratora: " + sender.getName())));
					}
					sender.sendMessage(ChatColorUtil.fixColor("&3Wyrzucono gracza" + cel.getName()));
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
			}
		return false;
	}
}
