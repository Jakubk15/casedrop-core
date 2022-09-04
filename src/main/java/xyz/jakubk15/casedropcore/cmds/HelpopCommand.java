package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.Lang;

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
			sender.sendMessage(Common.colorize(Lang.of("Commands.HelpopNoMessage")));
		} else {
			StringBuilder builder = new StringBuilder();
			for (String arg : args) {
				String s1 = arg + " ";
				builder.append(s1);
			}
			String result = builder.toString();
			for (Player ps : Remain.getOnlinePlayers()) {
				if (ps.hasPermission("essentials.helpop.receive") || ps.isOp()) {
					ps.sendMessage(Common.colorize(Lang.of("Commands.HelpopFormat")
							.replace("{sender}", sender.getName())
							.replace("{result}", result)));
					sender.sendMessage(Common.colorize(Lang.of("Commands.HelpopSent")));
				}
			}
		}
	}
}
