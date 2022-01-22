package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class FlyCommand extends SimpleCommand {

	public FlyCommand() {
		super("fly");
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.fly")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setAllowFlight(!target.isFlying());
					Player sender1 = (Player) sender;
					target.sendMessage(Util.color("&3Latanie zostało:") + (sender1.getAllowFlight() ? "włączone." : "wyłączone."));
				} else {
					Player sender1 = (Player) sender;
					sender1.setAllowFlight(!sender1.isFlying());
					sender.sendMessage(Util.color("&3Latanie zostało:") + (sender1.getAllowFlight() ? "włączone." : "wyłączone."));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień."));
			}
	}
}
