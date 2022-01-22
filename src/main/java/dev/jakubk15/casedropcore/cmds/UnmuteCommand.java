package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class UnmuteCommand extends SimpleCommand {

	public UnmuteCommand() {
		super("unmute");
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.unmute")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					if (MuteCommand.muted.contains(target.getUniqueId())) {
						MuteCommand.muted.remove(target.getUniqueId());
						sender.sendMessage(Util.color("&3Odciszono gracza " + target.getName()));
					} else {
						sender.sendMessage(Util.color("&cTen gracz nie jest wyciszony!"));
					}
				} else {
					sender.sendMessage(Util.color("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnien!"));
			}

	}
}
