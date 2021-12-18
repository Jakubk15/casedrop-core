package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UUIDCommand implements CommandExecutor {

	public UUIDCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (args.length > 0) {
				Player target = Bukkit.getPlayerExact(args[0]);
				assert target != null;
				sender.sendMessage(ChatColorUtil.fixColor("&3UUID gracza &b" + target.getName() + "&3 to &b" + target.getUniqueId()));
				return true;
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cPodaj prawidłowy nick gracza"));
			}
		return false;
	}
}
