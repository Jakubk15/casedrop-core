package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public class AlertCommand extends SimpleCommand {

	public AlertCommand() {
		super("alert");
		setMinArguments(2);
		setUsage("<type> <message>");
		setDescription("Sends alert with specified type and message to all players.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj prawidłowy typ alertu!");
		String type = args[0];
		String message = args[1];
		if (!type.equals("title") && !type.equals("actionbar") && !type.equals("chat")) {
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
				String title = (Util.color("&8* &4&lALERT &8*"));
				String subTitle = (Util.color(message));
				ps.sendTitle(title, subTitle, 5, 40, 5);
				return;
			}
		} else if (args[0].equals("actionbar")) {
			for (Player ps : Bukkit.getOnlinePlayers()) {
				String actionbar = (Util.color("&8* &4&lALERT &8*" + message));
				ps.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
				return;
			}
		}


	}

	@Override
	protected List<String> completeLastWordPlayerNames() {
		return super.completeLastWordPlayerNames();
	}
}
