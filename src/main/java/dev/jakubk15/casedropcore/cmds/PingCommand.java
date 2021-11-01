package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.CasedropCore;
import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PingCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player p) {
			for (int i = 0; i < 30; i++) {
				Bukkit.getScheduler().scheduleSyncRepeatingTask(CasedropCore.getInstance(), () -> p.sendMessage(ChatColorUtil.fixColor("&aTwój ping to: &6" + p.getPing())), 50, 1);
			}
		} else if (sender instanceof ConsoleCommandSender p) {
			p.sendMessage("Tylko gracz może tego użyć!");
		}
		return false;
	}
}
