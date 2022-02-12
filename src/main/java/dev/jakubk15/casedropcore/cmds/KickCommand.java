package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.command.SimpleCommand;

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
		PlayerUtil.kick(target, "&cZostałeś wyrzucony z serwera!\n\n&cPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]);
		sender.sendMessage(Common.colorize("&3Wyrzucono gracza" + target.getName()));
	}
}
