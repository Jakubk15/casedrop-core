package xyz.jakubk15.casedropcore.command;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.command.SimpleCommand;

public class BanIPCommand extends SimpleCommand {

	public BanIPCommand() {
		super("banip");
		setMinArguments(1);
		setPermission("essentials.banip");
		setDescription("Bans player IP");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj prawidłowy nick gracza");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		Bukkit.getBanList(BanList.Type.IP).addBan(target.getName(), Common.colorize("&cZostałeś zbanowany!\n\nPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]), null, sender.getName());
		PlayerUtil.kick(target, Common.colorize("&cZostałeś zbanowany!\n\nPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]));
		tell(Common.colorize("&3Zbanowano gracza " + target.getName() + "\n&3Powód: " + args[1]));
	}
}
