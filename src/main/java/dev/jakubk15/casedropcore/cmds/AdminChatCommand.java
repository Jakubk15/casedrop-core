package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminChatCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("essentials.adminchat")) {
			if (args[0] != null) {
				for (Player adm : Bukkit.getOnlinePlayers()) {
					if (adm.hasPermission("essentials.adminchat")) {
						adm.sendMessage(ChatColorUtil.fixColor("&8[&4AdminChat&8] » &7" + p.getName() + " &7» " + args[0]));
					}
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
			}
		} else {
			p.sendMessage("&cBrak uprawnień!");
		}
		return false;
	}
}
