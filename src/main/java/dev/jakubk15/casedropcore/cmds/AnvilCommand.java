package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AnvilCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
		if (commandSender instanceof Player p) {
			if (commandSender.hasPermission("essentials.anvil")) {
				p.openAnvil(null, true);
			} else {
				commandSender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień."));
			}
		} else {
			commandSender.sendMessage("Nie można wykonać tego polecenia z poziomu konsoli.");
		}
		return false;
	}
}