package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public class AdminChatCommand extends SimpleCommand {

	public AdminChatCommand() {
		super("adminchat|ac");
		setMinArguments(1);
		setUsage("<message>");
		setDescription("Sends message to all admins online.");
		setPermission("essentials.adminchat");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		for (Player adm : Bukkit.getOnlinePlayers()) {
			StringBuilder builder = new StringBuilder();
			for (String arg : args) {
				String s1 = arg + " ";
				builder.append(s1);
			}
			String result = builder.toString();
			adm.sendMessage(Util.color("&8[&4AdminChat&8] » &7" + sender.getName() + " &7» " + result));
		}
	}


	@Override
	protected List<String> completeLastWordPlayerNames() {
		return super.completeLastWordPlayerNames();
	}
}

