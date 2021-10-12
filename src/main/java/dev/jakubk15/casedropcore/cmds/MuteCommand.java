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
		Player p = (Player) sender;
		if (p.hasPermission("essentials.mute")) {
			if (args[0].length() >= 1) {
				Player cel = Bukkit.getPlayerExact(args[0]);
				assert cel != null;
				if (args[0].length() >= 1) {
					String reason = args[1];
					cel.sendMessage(ChatColorUtil.fixColor("&3Zostałeś wyciszony przez administratora " + p.getName() + " &3 za " + reason));
					muted.add(cel.getUniqueId());
				} else {
					cel.sendMessage(ChatColorUtil.fixColor("&3Zostałeś wyciszony przez administratora " + p.getName()));
					muted.add(cel.getUniqueId());
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cPodaj nick gracza!"));
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
