package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MuteCommand implements CommandExecutor, Listener {

	public MuteCommand() {}

	public static Set<UUID> muted = new HashSet<>();

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.mute")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					String reason = args[1];
					target.sendMessage(ChatColorUtil.fixColor("&3Zostałeś wyciszony przez administratora " + sender.getName() + " &3 za " + reason));
					muted.add(target.getUniqueId());
					return true;
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
					return false;
				}
			}
		return false;
	}

	@EventHandler
	private void onChat(AsyncChatEvent event) {
		if (muted.contains(event.getPlayer().getUniqueId())) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColorUtil.fixColor("&cJesteś wyciszony!"));
		}

	}


}
