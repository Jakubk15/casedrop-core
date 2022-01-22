package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class IPCommand extends SimpleCommand {

	public IPCommand() {
		super("ip");
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.ip")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					sender.sendMessage(Util.color("&3IP gracza &b") + target.getName() + " &3to &b" + target.getAddress());
				} else {
					sender.sendMessage(Util.color("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
			}
	}
}
