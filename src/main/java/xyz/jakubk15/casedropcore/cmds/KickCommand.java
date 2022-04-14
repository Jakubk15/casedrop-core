package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class KickCommand extends SimpleCommand {

	public KickCommand() {
		super("kick");
		setPermission("essentials.kick");
		setMinArguments(1);
		setUsage("<player> [reason]");
		setDescription("Kicks player.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj nick gracza!");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		PlayerUtil.kick(target, Lang.of("Commands.Kicked")
				.replace("{admin}", sender.getName())
				.replace("{reason}", args[1]));
		sender.sendMessage(Common.colorize(Lang.of("Commands.Kick").replace("{player}", target.getName())));
	}
}
