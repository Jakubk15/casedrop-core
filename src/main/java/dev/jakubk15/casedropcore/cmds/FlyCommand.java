package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class FlyCommand extends SimpleCommand {

	public FlyCommand() {
		super("fly");
		setMinArguments(0);
		setPermission("essentials.fly");
		setUsage("[player]");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayerExact(args[0]);
			if (target == null) return;
			target.setAllowFlight(!target.isFlying());
			Player sender1 = (Player) sender;
			target.sendMessage(Common.colorize("&3Latanie zostało:") + (sender1.getAllowFlight() ? "włączone." : "wyłączone."));
		} else {
			Player sender1 = (Player) sender;
			sender1.setAllowFlight(!sender1.isFlying());
			tell(Common.colorize("&3Latanie zostało:") + (sender1.getAllowFlight() ? "włączone." : "wyłączone."));
		}
	}
}
