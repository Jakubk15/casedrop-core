package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

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
		setPermissionMessage("&cBrak uprawnień.");
	}

	public static Set<UUID> muted = new HashSet<>();

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj nick gracza.");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		String reason = args[1];
		target.sendMessage(Common.colorize(Lang.of("Commands.Muted")
				.replace("{admin}", sender.getName())
				.replace("{reason}", reason)));
		muted.add(target.getUniqueId());

	}

	@EventHandler
	private void onChat(AsyncPlayerChatEvent event) {
		if (muted.contains(event.getPlayer().getUniqueId())) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(Common.colorize(Lang.of("Commands.MutedEvent")));
		}
	}


}
