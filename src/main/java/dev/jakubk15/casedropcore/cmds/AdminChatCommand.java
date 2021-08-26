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
			if (args[0].length() >= 1) {
				for (Player adm : Bukkit.getOnlinePlayers()) {
					if (adm.hasPermission("essentials.adminchat")) {
						StringBuilder builder = new StringBuilder();
						for (String arg : args) {
							String s1 = arg + " ";
							builder.append(s1);
						}
						String result = builder.toString();
						adm.sendMessage(ChatColorUtil.fixColor("&8[&4AdminChat&8] » &7" + p.getName() + " &7» " + result));
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
