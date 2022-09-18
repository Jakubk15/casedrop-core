package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class ChatManager extends SimpleCommand implements Listener {

	public ChatManager() {
		super("chat|chatmanager");
		setMinArguments(1);
		setPermission("essentials.chat.admin");
		setDescription("Chat manager main command.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	public static boolean isMuted;

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("essentials.chat.bypass")) {
			if (isMuted) {
				e.setCancelled(true);
				p.sendMessage(Common.colorize(Lang.of("Commands.ChatMuted")));
			}
		}
	}

	@Override
	public void onCommand() {
		checkArgs(1, Lang.of("Commands.Invalid_Chat_Type"));
		if (args[0].equalsIgnoreCase("on")) {
			isMuted = false;
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatHeader")));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatEnabled")));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatHeader")));
				return;
			}
		} else if (args[0].equalsIgnoreCase("off")) {
			isMuted = true;
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatHeader")));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatDisabled")));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatHeader")));
				return;
			}
		} else if (args[0].equalsIgnoreCase("clear")) {
			for (Player all : Bukkit.getOnlinePlayers()) {
				for (int i = 0; i < 500; i++) {
					all.sendMessage(" ");
				}
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatHeader")));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatCleared")));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize(Lang.of("Commands.ChatHeader")));
				return;
			}
		} else {
			sender.sendMessage(Common.colorize(Lang.of("Commands.Invalid_Chat_Type")));
		}

	}
}
