package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class IPCommand extends SimpleCommand {

	public IPCommand() {
		super("ip");
		setMinArguments(1);
		setUsage("<player>");
		setPermission("essentials.ip");
		setDescription("Gets player IPv4 address.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj nick gracza");
		Player target = Bukkit.getPlayerExact(args[0]);
		assert target != null;
		sender.sendMessage(Util.color("&3IP gracza &b") + target.getName() + " &3to &b" + target.getAddress());
	}
}
