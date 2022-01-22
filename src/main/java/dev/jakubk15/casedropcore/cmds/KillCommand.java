package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class KillCommand extends SimpleCommand {

	public KillCommand() {
		super("kill");
	}

	@Override
	public void onCommand() {
		if (sender.hasPermission("essentials.kill")) {
			Player target = Bukkit.getPlayerExact(args[0]);
			target.setHealth(0);
			sender.sendMessage(Util.color("&3Zabito gracza &b" + target.getName()));
		}
	}
}
