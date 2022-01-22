package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class AdminChatCommand extends SimpleCommand {

	public AdminChatCommand() {
		super("adminchat|ac");
		setMinArguments(1);
		setUsage("<message>");
		setDescription("Sends message to all admins online.");
		setPermission("essentials.adminchat");
	}

	@Override
	public void onCommand() {
		if (sender.hasPermission("essentials.adminchat")) {
			if (args.length > 0) {
				for (Player adm : Bukkit.getOnlinePlayers()) {
					StringBuilder builder = new StringBuilder();
					for (String arg : args) {
						String s1 = arg + " ";
						builder.append(s1);
					}
					String result = builder.toString();
					adm.sendMessage(Util.color("&8[&4AdminChat&8] » &7" + sender.getName() + " &7» " + result));
				}
			} else {
				sender.sendMessage(Util.color("&cPodaj wiadomość!"));
			}
		} else {
			sender.sendMessage("&cBrak uprawnień!");
		}
	}

}

