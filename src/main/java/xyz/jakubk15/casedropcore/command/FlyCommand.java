package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

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
			Common.tell(target, Lang.of("Commands.Fly").replace("{status}", target.getAllowFlight() ? "&aenabled." : "&cdisabled."));
			Common.tell(sender1, Lang.of("Commands.Fly").replace("{status}", target.getAllowFlight() ? "&aenabled." : "&cdisabled."));
		} else {
			Player sender1 = (Player) sender;
			sender1.setAllowFlight(!sender1.isFlying());
			Common.tell(sender1, Lang.of("Commands.Fly").replace("{status}", sender1.getAllowFlight() ? "&aenabled." : "&cdisabled."));
		}
	}
}
