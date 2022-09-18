package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

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
		tell(Lang.of("Commands.Kill").replace("{player}", target.getName()));
	}
}
