package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class KillCommand extends SimpleCommand {

	public KillCommand() {
		super("kill");
		setPermission("essentials.kill");
		setMinArguments(1);
		setUsage("<player>");
		setDescription("Kills player");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		target.setHealth(0);
		tell("&3Zabito gracza &b" + target.getName());
	}
}
