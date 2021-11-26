package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MuteCommand implements CommandExecutor {


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
				} else {
					sender.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
				}
			}
		return false;
	}

	private void onChat(AsyncChatEvent e) {
		Player p = e.getPlayer();
		if (muted.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
	}


}
