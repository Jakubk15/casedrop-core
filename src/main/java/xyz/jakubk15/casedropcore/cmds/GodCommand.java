package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class GodCommand extends SimpleCommand {

	public GodCommand() {
		super("god");
		setMinArguments(0);
		setDescription("Enables/disables godmode.");
		setPermission("essentials.god");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) return;
			target.setInvulnerable(!target.isInvulnerable());
			sender.sendMessage(Common.colorize(target.isInvulnerable() ? Lang.of("Commands.GodmodeDisabled") : Lang.of("Command.GodmodeEnabled")));
		} else {
			Player sender1 = (Player) sender;
			sender1.setInvulnerable(!sender1.isInvulnerable());
			sender.sendMessage(Common.colorize(sender1.isInvulnerable() ? Lang.of("Commands.GodmodeDisabled") : Lang.of("Command.GodmodeEnabled")));
		}
	}
}
