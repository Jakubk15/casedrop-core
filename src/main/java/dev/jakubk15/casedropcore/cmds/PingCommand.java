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

	public PingCommand() {
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof ConsoleCommandSender)) {
			Player sender1 = (Player) sender;
			for (int i = 0; i < 30; i++) {
				Bukkit.getScheduler().scheduleSyncRepeatingTask(CasedropCore.getInstance(), () -> sender.sendMessage(ChatColorUtil.fixColor("&aTwój ping to: &6" + sender1.getPing())), 50, 1);
			}
		}
		return false;
	}
}
