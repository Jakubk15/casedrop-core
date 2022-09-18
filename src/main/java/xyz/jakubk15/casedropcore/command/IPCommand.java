package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

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
		if (target == null) {
			tell(Lang.of("Commands.Invalid_PlayerNickName"));
		}
		if (target != null) {
			sender.sendMessage(Common.colorize("&3IP gracza &b") + target.getName() + " &3to &b" + target.getAddress());
		}
		sender.sendMessage(Common.colorize(Lang.of("Commands.IP_Command")
				.replace("{player}", target.getName())
				.replace("{InetSocketAddress}", target.getAddress().toString())));
	}
}
