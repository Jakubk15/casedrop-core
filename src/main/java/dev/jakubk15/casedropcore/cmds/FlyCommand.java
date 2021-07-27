package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("essentials.fly")) {
			if (args[0].length() >= 1) {
				Player cel = Bukkit.getPlayerExact(args[0]);
				cel.setAllowFlight(!cel.isFlying());
				cel.sendMessage(ChatColorUtil.fixColor("&3Latanie zostało:") + (p.getAllowFlight() ? "włączone." : "wyłączone."));
			} else {
				p.setAllowFlight(!p.isFlying());
				p.sendMessage(ChatColorUtil.fixColor("&3Latanie zostało:") + (p.getAllowFlight() ? "włączone." : "wyłączone."));
			}
		}
		return false;
	}
}
