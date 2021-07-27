package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IPCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("essentials.ip")) {
			if (args[0].length() >= 1) {
				Player cel = Bukkit.getPlayerExact(args[0]);
				p.sendMessage(ChatColorUtil.fixColor("&3IP gracza &b") + cel.getName() + " &3to &b" + cel.getAddress());
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
			}
		} else {
			p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
		}
		return false;
	}
}
