package dev.jakubk15.casedropcore.cmds;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class BanCommand extends SimpleCommand {

	public BanCommand() {
		super("ban");
		setMinArguments(1);
		setPermission("essentials.ban");
		setDescription("Bans player.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj prawidłowy nick gracza!");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), Common.colorize("&cZostałeś zbanowany!\n\nPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]), null, sender.getName());
		tell(Common.colorize("&3Zbanowano gracza " + target.getName() + "\n&3Powód: " + args[1]));
	}
}
