package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class BanCommand extends SimpleCommand {

	public BanCommand() {
		super("ban");
		setMinArguments(1);
		setPermission("essentials.ban");
		setDescription("Bans player.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj prawidłowy nick gracza!");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), Util.color("&cZostałeś zbanowany!\n\nPrzez administratora: " + sender.getName() + "\n\n&cPowód: " + args[1]), null, sender.getName());
		tell(Util.color("&3Zbanowano gracza " + target.getName() + "\n&3Powód: " + args[1]));
	}
}
