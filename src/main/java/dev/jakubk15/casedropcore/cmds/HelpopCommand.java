package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class HelpopCommand extends SimpleCommand {

	public HelpopCommand() {
		super("helpop");
		setUsage("<message>");
		setMinArguments(1);
		setDescription("Sends a message to operators.");
	}

	@Override
	public void onCommand() {
		if (args[0].isEmpty()) {
			sender.sendMessage(Common.colorize("&cPodaj wiadomość!"));
		} else {
			StringBuilder builder = new StringBuilder();
			for (String arg : args) {
				String s1 = arg + " ";
				builder.append(s1);
			}
			String result = builder.toString();
			for (Player ps : Bukkit.getOnlinePlayers()) {
				if (ps.hasPermission("essentials.helpop.receive") || ps.isOp()) {
					ps.sendMessage(Common.colorize("&8[&4Helpop&8] &c" + sender.getName() + ": " + result));
					sender.sendMessage(Common.colorize("&8[&4Helpop&8] &7Wiadomość wysłana do administracji!"));
				}
			}
		}
	}
}
