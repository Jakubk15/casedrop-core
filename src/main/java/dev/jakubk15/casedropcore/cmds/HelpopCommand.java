package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelpopCommand implements CommandExecutor {

	public HelpopCommand() {
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (args[0].isEmpty()) {
				sender.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
			} else {
				StringBuilder builder = new StringBuilder();
				for (String arg : args) {
					String s1 = arg + " ";
					builder.append(s1);
				}
				String result = builder.toString();
				for (Player ps : Bukkit.getOnlinePlayers()) {
					if (ps.hasPermission("essentials.helpop.receive") || ps.isOp()) {
						ps.sendMessage(ChatColorUtil.fixColor("&8[&4Helpop&8] &c" + sender.getName() + ": " + result));
						sender.sendMessage(ChatColorUtil.fixColor("&8[&4Helpop&8] &7Wiadomość wysłana do administracji!"));
					}
				}
			}
		return false;
	}
}
