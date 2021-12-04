package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {

	public VanishCommand() {
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.vanish")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					sender.sendMessage(ChatColorUtil.fixColor(target.isInvisible() ? "&3Włączono " : "&3Wyłączono " + "vanisha dla gracza " + target.getName()));
					target.setInvisible(!target.isInvisible());
				} else {
					Player sender1 = (Player) sender;
					sender.sendMessage(ChatColorUtil.fixColor(sender1.isInvisible() ? "&3Włączono " : "&3Wyłączono " + "vanisha."));
					sender1.setInvisible(!sender1.isInvisible());
				}
			}
		return false;
	}
	}

