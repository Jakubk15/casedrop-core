package dev.jakubk15.casedropcore.cmds;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public class AlertCommand extends SimpleCommand {

	public AlertCommand() {
		super("alert");
		setMinArguments(2);
		setUsage("<type> <message>");
		setDescription("Sends alert with specified type and message to all players.");
		setPermission("essentials.broadcast");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj prawidłowy typ alertu!");
		String type = args[0];
		String message = args[1];
		if (!type.equals("title") && !type.equals("actionbar") && !type.equals("chat")) {
			sender.sendMessage(Common.colorize("&cPodaj prawidłowy typ alertu!"));
		} else if (args[0].equals("chat")) {
			for (Player ps : Bukkit.getOnlinePlayers()) {
				ps.sendMessage(Common.colorize("&8&m---------- &8&l[ &3&lALERT&8&l ]&8&m ----------"));
				ps.sendMessage(Common.colorize(" "));
				ps.sendMessage(Common.colorize("          " + message + "          "));
				ps.sendMessage(Common.colorize(" "));
				ps.sendMessage(Common.colorize("&8&m---------- &8&l[ &3&lALERT&8&l ]&8&m ----------"));
				return;
			}
		} else if (args[0].equals("title")) {
			for (Player ps : Bukkit.getOnlinePlayers()) {
				String title = (Common.colorize("&8* &4&lALERT &8*"));
				String subTitle = (Common.colorize(message));
				ps.sendTitle(title, subTitle, 5, 40, 5);
				return;
			}
		} else if (args[0].equals("actionbar")) {
			for (Player ps : Bukkit.getOnlinePlayers()) {
				String actionbar = (Common.colorize("&8* &4&lALERT &8*" + message));
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
