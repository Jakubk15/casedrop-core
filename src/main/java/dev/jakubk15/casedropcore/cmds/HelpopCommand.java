package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelpopCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player p) {
			if (args[0].isEmpty()) {
				p.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
			} else {
				StringBuilder builder = new StringBuilder();
				for (String arg : args) {
					String s1 = arg + " ";
					builder.append(s1);
				}
				String result = builder.toString();
				for (Player ps : Bukkit.getOnlinePlayers()) {
					if (ps.hasPermission("essentials.helpop.receive") || ps.isOp()) {
						ps.sendMessage(ChatColorUtil.fixColor("&8[&4Helpop&8] &c" + p.getName() + ": " + result));
						p.sendMessage(ChatColorUtil.fixColor("&8[&4Helpop&8] &7Wiadomość wysłana do administracji!"));
					}
				}
			}
		} else if (sender instanceof ConsoleCommandSender p) {
			if (args[0].isEmpty()) {
				p.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
			} else {
				StringBuilder builder = new StringBuilder();
				for (String arg : args) {
					String s1 = arg + " ";
					builder.append(s1);
				}
				String result = builder.toString();
				for (Player ps : Bukkit.getOnlinePlayers()) {
					if (ps.hasPermission("essentials.helpop.receive") || ps.isOp()) {
						ps.sendMessage(ChatColorUtil.fixColor("&8[&4Helpop&8] &c" + p.getName() + ": " + result));
						p.sendMessage(ChatColorUtil.fixColor("&8[&4Helpop&8] &7Wiadomość wysłana do administracji!"));
					}
				}
			}
		}
		return false;
	}
}
