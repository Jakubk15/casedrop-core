package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class BanIPCommand extends SimpleCommand {

	public BanIPCommand() {
		super("banip");
		setMinArguments(1);
		setPermission("essentials.banip");
		setDescription("Bans player IP");
	}

	@Override
	public void onCommand() {
		if (sender.hasPermission("essentials.banip")) {
			if (args.length > 0) {
				Player target = Bukkit.getPlayerExact(args[0]);
				assert target != null;
				target.banPlayerFull(Util.color("&cZostałeś zbanowany na IP!\n\nPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]));
				sender.sendMessage(Util.color("&3Zbanowano gracza " + target.getName() + "\n&3Powód: " + args[1]));
			} else {
				sender.sendMessage(Util.color("&cPodaj nick gracza!"));
			}
		} else {
			sender.sendMessage(Util.color("&cBrak uprawnien!"));
		}
	}
}
