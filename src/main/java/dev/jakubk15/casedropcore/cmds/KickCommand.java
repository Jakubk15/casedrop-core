package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerKickEvent;
import org.mineacademy.fo.command.SimpleCommand;

public class KickCommand extends SimpleCommand {

	public KickCommand() {
		super("kick");
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.kick")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.kick(null, PlayerKickEvent.Cause.valueOf(Util.color("&cZostałeś wyrzucony z serwera!\n\n&cPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1])));
					sender.sendMessage(Util.color("&3Wyrzucono gracza" + target.getName()));
				} else {
					sender.sendMessage(Util.color("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnien!"));
			}
	}
}
