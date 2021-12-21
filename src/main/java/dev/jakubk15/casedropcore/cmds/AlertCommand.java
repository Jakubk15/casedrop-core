package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AlertCommand implements CommandExecutor {

	public AlertCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.broadcast")) {
				if (args.length > 0) {
						final String message = args[1];
						if (!args[0].equals("title") && !args[0].equals("actionbar") && !args[0].equals("chat")) {
							sender.sendMessage(ChatColorUtil.fixColor("&cPodaj prawidłowy typ alertu!"));
							return false;
						} else if (args[0].equals("chat")) {
							for (Player ps : Bukkit.getOnlinePlayers()) {
								ps.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lALERT&8&l ]&8&m ----------"));
								ps.sendMessage(ChatColorUtil.fixColor(" "));
								ps.sendMessage(ChatColorUtil.fixColor("          " + message + "          "));
								ps.sendMessage(ChatColorUtil.fixColor(" "));
								ps.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lALERT&8&l ]&8&m ----------"));
								return true;
							}
						} else if (args[0].equals("title")) {
							for (Player ps : Bukkit.getOnlinePlayers()) {
								final Component mainTitle = Component.text(ChatColorUtil.fixColor("&8* &4&lALERT &8*"));
								final Component subTitle = Component.text(ChatColorUtil.fixColor(message));
								final Title title = Title.title(mainTitle, subTitle);
								ps.showTitle(title);
								return true;
							}
						} else if (args[0].equals("actionbar")) {
							for (Player ps : Bukkit.getOnlinePlayers()) {
								final Component actionbar = Component.text(ChatColorUtil.fixColor("&8* &4&lALERT &8*" + message));
								ps.sendActionBar(actionbar);
								return true;
							}
						}
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj prawidłowy typ alertu!"));
					return false;
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
				return false;
			}

		return false;
	}
}
