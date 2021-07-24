package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AlertCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("essentials.broadcast")) {
			if (args[0].length() > 1) {
				if (args[1].length() > 1) {
					String message = args[1];
					if (!args[0].equals("title") && !args[0].equals("actionbar") && !args[0].equals("chat")) {
						p.sendMessage(ChatColorUtil.fixColor("&cPodaj prawidłowy typ alertu!"));
					} else if (args[0].equals("chat")) {
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lALERT&8&l ]&8&m ----------"));
							ps.sendMessage(ChatColorUtil.fixColor(" "));
							ps.sendMessage(ChatColorUtil.fixColor("          " + message + "          "));
							ps.sendMessage(ChatColorUtil.fixColor(" "));
							ps.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lALERT&8&l ]&8&m ----------"));
						}
					} else if (args[0].equals("title")) {
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.sendTitle(ChatColorUtil.fixColor("&8&l[ &4&lALERT&8&l ]&r"), message, 1, 4, 1);
						}
					} else if (args[0].equals("actionbar")) {
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.sendActionBar(ChatColorUtil.fixColor("&8&l[ &4&lALERT&8&l &r] " + message));
						}
					}
				} else {
					p.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cPodaj prawidłowy typ alertu!"));
			}
		} else {
			p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
		}
		return false;
	}
}
