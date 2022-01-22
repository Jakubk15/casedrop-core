package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class MsgCommand extends SimpleCommand {

	public MsgCommand() {
		super("msg|message|whisper|tell");
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.msg")) {
				if (args.length > 0) {
						Player target = Bukkit.getPlayerExact(args[0]);
						if (target != null) {
							String msg = args[1];
							target.sendMessage(Util.color("&3[&b" + sender.getName() + "&3 -> " + target.getName() + "&3] &7" + msg));
							sender.sendMessage(Util.color("&3[&b" + sender.getName() + "&3 -> " + target.getName() + "&3] &7" + msg));
						} else {
							sender.sendMessage(Util.color("&cPodany gracz jest offline lub nie był nigdy na serwerze!"));
						}
				} else {
					sender.sendMessage(Util.color("&cPodaj nick gracza!"));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnien!"));
			}
	}
}
