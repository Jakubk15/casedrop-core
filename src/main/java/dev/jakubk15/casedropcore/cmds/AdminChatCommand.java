package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminChatCommand implements CommandExecutor {

	public AdminChatCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.adminchat")) {
				if (args.length > 0) {
					for (Player adm : Bukkit.getOnlinePlayers()) {
						if (adm.hasPermission("essentials.adminchat")) {
							StringBuilder builder = new StringBuilder();
							for (String arg : args) {
								String s1 = arg + " ";
								builder.append(s1);
							}
							String result = builder.toString();
							adm.sendMessage(ChatColorUtil.fixColor("&8[&4AdminChat&8] » &7" + sender.getName() + " &7» " + result));
						}
					}
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj wiadomość!"));
				}
			} else {
				sender.sendMessage("&cBrak uprawnień!");
			}
		return false;
	}
}

