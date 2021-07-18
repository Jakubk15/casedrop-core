package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelpopCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player p = (Player) sender;
		if (args[0].isEmpty()) {
			p.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
		} else {
			for (Player ps : Bukkit.getOnlinePlayers()) {
				if (ps.hasPermission("essentials.helpop.receive") || ps.isOp()) {
					ps.sendMessage(ChatColorUtil.fixColor("&8[&4Helpop&8] &c" + p.getName() + ": " + args[0]));
					p.sendMessage(ChatColorUtil.fixColor("&8[&4Helpop&8] &7Wiadomość wysłana do administracji!"));
				}
			}
		}
		return false;
	}
}
