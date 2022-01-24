package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.command.SimpleCommand;

public class KickCommand extends SimpleCommand {

	public KickCommand() {
		super("kick");
		setPermission("essentials.kick");
		setMinArguments(1);
		setUsage("<player> [reason]");
		setDescription("Kicks player.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj nick gracza!");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		PlayerUtil.kick(target, "&cZostałeś wyrzucony z serwera!\n\n&cPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]);
		sender.sendMessage(Util.color("&3Wyrzucono gracza" + target.getName()));
	}
}
