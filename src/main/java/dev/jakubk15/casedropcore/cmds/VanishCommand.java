package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player p = (Player) sender;
		// TODO skrócić ten syf
		if (p.hasPermission("essentials.vanish")) {
			if (args[0].length() >= 1) {
				Player cel = Bukkit.getPlayerExact(args[0]);
				assert cel != null;
				p.sendMessage(ChatColorUtil.fixColor(cel.isInvisible() ? "&3Włączono " : "&3Wyłączono " + "vanisha dla gracza " + cel.getName()));
				cel.setInvisible(!cel.isInvisible());
			} else {
				p.sendMessage(ChatColorUtil.fixColor(p.isInvisible() ? "&3Włączono " : "&3Wyłączono " + "vanisha."));
				p.setInvisible(!p.isInvisible());
			}
		}
		return false;
	}
}
