package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class VanishCommand extends SimpleCommand {

	public VanishCommand() {
		super("vanish|v");
		setPermission("essentials.vanish");
		setUsage("<player>");
		setDescription("Włącza/wyłącza vanisha.");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayerExact(args[0]);
			if (target == null) return;
			tell(target.isInvisible() ? "&3Włączono " : "&3Wyłączono " + "vanisha dla gracza " + target.getName());
			target.setInvisible(!target.isInvisible());
		} else {
			Player sender1 = (Player) sender;
			tell(sender1.isInvisible() ? "&3Włączono " : "&3Wyłączono " + "vanisha.");
			sender1.setInvisible(!sender1.isInvisible());
		}
	}
}


