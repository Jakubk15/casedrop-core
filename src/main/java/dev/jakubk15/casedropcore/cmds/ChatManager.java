package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.mineacademy.fo.command.SimpleCommand;

public class ChatManager extends SimpleCommand implements Listener {

	public ChatManager() {
		super("chat|chatmanager");
	}

	public static boolean isMuted;

	@EventHandler
	public void onChat(AsyncChatEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("essentials.chat.*")) {
			if (ChatManager.isMuted) {
				e.setCancelled(true);
				p.sendMessage(Util.color("&cObecnie chat jest wyciszony!"));
			}
		}
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.chat.*")) {
				if (args.length > 0) {
					if (args[0].equalsIgnoreCase("on")) {
						isMuted = false;
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(Util.color("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							all.sendMessage(Util.color(""));
							all.sendMessage(Util.color("              &3Chat został &awłączony!"));
							all.sendMessage(Util.color(""));
							all.sendMessage(Util.color("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							return;
						}
					} else if (args[0].equalsIgnoreCase("off")) {
						isMuted = true;
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(Util.color("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							all.sendMessage(Util.color(""));
							all.sendMessage(Util.color("              &3Chat został &cwyłączony!"));
							all.sendMessage(Util.color(""));
							all.sendMessage(Util.color("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							return;
						}
					} else if (args[0].equalsIgnoreCase("clear")) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							for (int i = 0; i < 500; i++) {
								all.sendMessage(" ");
							}
							all.sendMessage(Util.color("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							all.sendMessage(Util.color(""));
							all.sendMessage(Util.color("              &3Chat został &bwyczyszczony!"));
							all.sendMessage(Util.color(""));
							all.sendMessage(Util.color("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							return;
						}
					} else {
						sender.sendMessage(Util.color("&cPodaj prawidłowy argument; Dostępne: on, off, clear."));
					}
				} else {
					sender.sendMessage(Util.color("&cPodaj prawidłowy argument; Dostępne: on, off, clear."));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
		}
	}
}
