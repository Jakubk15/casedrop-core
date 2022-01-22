package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MuteCommand extends SimpleCommand implements Listener {

	public MuteCommand() {
		super("mute");
		setPermission("essentials.mute");
		setUsage("<player> [reason]");
		setDescription("Mutes player with reason (if specified).");
		setMinArguments(1);
	}

	public static Set<UUID> muted = new HashSet<>();

	@Override
	public void onCommand() {
		if (sender.hasPermission("essentials.mute")) {
			if (args.length > 0) {
				Player target = Bukkit.getPlayerExact(args[0]);
				assert target != null;
				String reason = args[1];
				target.sendMessage(Util.color("&3Zostałeś wyciszony przez administratora " + sender.getName() + " &3 za " + reason));
				muted.add(target.getUniqueId());
			} else {
				sender.sendMessage(Util.color("&cPodaj nick gracza!"));
			}
		}
	}

	@EventHandler
	private void onChat(AsyncChatEvent event) {
		if (muted.contains(event.getPlayer().getUniqueId())) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(Util.color("&cJesteś wyciszony!"));
		}

	}


}
