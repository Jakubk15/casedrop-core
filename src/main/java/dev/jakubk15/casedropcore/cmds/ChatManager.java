package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class ChatManager implements Listener, CommandExecutor {

	public ChatManager() {
	}

	public static boolean isMuted;

	public void onChat(AsyncChatEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("essentials.chat.*")) {
			if (ChatManager.isMuted) {
				e.setCancelled(true);
				p.sendMessage(ChatColorUtil.fixColor("&cObecnie chat jest wyciszony!"));
			}
		}
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.chat.*")) {
				if (args.length > 0) {
					if (args[0].equalsIgnoreCase("on")) {
						isMuted = false;
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							all.sendMessage(ChatColorUtil.fixColor(""));
							all.sendMessage(ChatColorUtil.fixColor("              &3Chat został &awłączony!"));
							all.sendMessage(ChatColorUtil.fixColor(""));
							all.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
						}
					} else if (args[0].equalsIgnoreCase("off")) {
						isMuted = true;
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							all.sendMessage(ChatColorUtil.fixColor(""));
							all.sendMessage(ChatColorUtil.fixColor("              &3Chat został &cwyłączony!"));
							all.sendMessage(ChatColorUtil.fixColor(""));
							all.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
						}
					} else if (args[0].equalsIgnoreCase("clear")) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							for (int i = 0; i < 500; i++) {
								all.sendMessage(" ");
							}
							all.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
							all.sendMessage(ChatColorUtil.fixColor(""));
							all.sendMessage(ChatColorUtil.fixColor("              &3Chat został &bwyczyszczony!"));
							all.sendMessage(ChatColorUtil.fixColor(""));
							all.sendMessage(ChatColorUtil.fixColor("&8&m---------- &8&l[ &3&lCHAT &8&l ] &8&m----------"));
						}
					} else {
						sender.sendMessage(ChatColorUtil.fixColor("&cPodaj prawidłowy argument; Dostępne: on, off, clear."));
					}
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj prawidłowy argument; Dostępne: on, off, clear."));
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
	}
		return false;
	}
}
