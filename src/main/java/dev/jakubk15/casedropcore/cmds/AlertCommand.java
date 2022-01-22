package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class AlertCommand extends SimpleCommand {

	public AlertCommand() {
		super("alert");
		setMinArguments(2);
		setUsage("<type> <message>");
		setDescription("Sends alert with specified type and message to all players.");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			String message = args[1];
			if (!args[0].equals("title") && !args[0].equals("actionbar") && !args[0].equals("chat")) {
				sender.sendMessage(Util.color("&cPodaj prawidłowy typ alertu!"));
			} else if (args[0].equals("chat")) {
				for (Player ps : Bukkit.getOnlinePlayers()) {
					ps.sendMessage(Util.color("&8&m---------- &8&l[ &3&lALERT&8&l ]&8&m ----------"));
					ps.sendMessage(Util.color(" "));
					ps.sendMessage(Util.color("          " + message + "          "));
					ps.sendMessage(Util.color(" "));
					ps.sendMessage(Util.color("&8&m---------- &8&l[ &3&lALERT&8&l ]&8&m ----------"));
					return;
				}
			} else if (args[0].equals("title")) {
				for (Player ps : Bukkit.getOnlinePlayers()) {
					Component mainTitle = Component.text(Util.color("&8* &4&lALERT &8*"));
					Component subTitle = Component.text(Util.color(message));
					Title title = Title.title(mainTitle, subTitle);
					ps.showTitle(title);
					return;
				}
			} else if (args[0].equals("actionbar")) {
				for (Player ps : Bukkit.getOnlinePlayers()) {
					Component actionbar = Component.text(Util.color("&8* &4&lALERT &8*" + message));
					ps.sendActionBar(actionbar);
					return;
				}
			}
		} else {
			sender.sendMessage(Util.color("&cPodaj prawidłowy typ alertu!"));
		}


	}
}
