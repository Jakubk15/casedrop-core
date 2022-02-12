package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

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
				p.sendMessage(Common.colorize("&cObecnie chat jest wyciszony!"));
			}
		}
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj prawidłowy argument. Dostępne: on, off, clear");
		if (args[0].equalsIgnoreCase("on")) {
			isMuted = false;
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(Common.colorize("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize("              &3Chat został &awłączony!"));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
				return;
			}
		} else if (args[0].equalsIgnoreCase("off")) {
			isMuted = true;
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(Common.colorize("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize("              &3Chat został &cwyłączony!"));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
				return;
			}
		} else if (args[0].equalsIgnoreCase("clear")) {
			for (Player all : Bukkit.getOnlinePlayers()) {
				for (int i = 0; i < 500; i++) {
					all.sendMessage(" ");
				}
				all.sendMessage(Common.colorize("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize("              &3Chat został &bwyczyszczony!"));
				all.sendMessage(Common.colorize(""));
				all.sendMessage(Common.colorize("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
				return;
			}
		} else {
			sender.sendMessage(Common.colorize("&cPodaj prawidłowy argument; Dostępne: on, off, clear."));
		}

	}
}
