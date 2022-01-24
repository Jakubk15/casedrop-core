package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class GodCommand extends SimpleCommand {

	public GodCommand() {
		super("god");
		setMinArguments(0);
		setDescription("Enables/disables godmode.");
		setPermission("essentials.god");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayerExact(args[0]);
			if (target == null) return;
			target.setInvulnerable(!target.isInvulnerable());
			sender.sendMessage(Util.color("&3Godmode " + (target.isInvulnerable() ? "&3włączone" : "&3wyłączone")));
		} else {
			Player sender1 = (Player) sender;
			sender1.setInvulnerable(!sender1.isInvulnerable());
			sender.sendMessage(Util.color("&3Godmode " + (sender1.isInvulnerable() ? "&3włączone" : "&3wyłączone")));
		}
	}
}
