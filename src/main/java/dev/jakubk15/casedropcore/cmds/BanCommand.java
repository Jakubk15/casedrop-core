package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class BanCommand extends SimpleCommand {

	public BanCommand() {
		super("ban");
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.ban")) {
				if (args.length > 0) {
					final Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
						target.banPlayer(Util.color("&cZostałeś zbanowany!\n\nPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]));
						sender.sendMessage(Util.color("&3Zbanowano gracza " + target.getName() + "\n&3Powód: " + args[1]));
				} else {
					sender.sendMessage(Util.color("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
			}
	}
}
