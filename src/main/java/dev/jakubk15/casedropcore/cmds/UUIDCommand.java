package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UUIDCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (args[0].length() >= 1) {
				Player cel = Bukkit.getPlayerExact(args[0]);
				assert cel != null;
				sender.sendMessage(ChatColorUtil.fixColor("&3UUID gracza &b" + cel.getName() + "&3 to &b" + cel.getUniqueId()));
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cPodaj prawidłowy nick gracza"));
			}
		return false;
	}
}
