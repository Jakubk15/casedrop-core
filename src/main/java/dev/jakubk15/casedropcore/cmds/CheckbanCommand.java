package dev.jakubk15.casedropcore.cmds;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.Date;

public class CheckbanCommand extends SimpleCommand {
	
	public CheckbanCommand() {
		super("checkban|bancheck");
		setMinArguments(1);
		setUsage("<player>");
		setDescription("Check if player is banned.");
		setPermission("essentials.checkban");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	protected void onCommand() {
		checkArgs(1, "&cPodaj nick gracza.");
		Player target = Bukkit.getPlayer(args[0]);
		if (target.isBanned()) {
			BanList bl0 = Bukkit.getBanList(BanList.Type.NAME);
			BanList bl1 = Bukkit.getBanList(BanList.Type.IP);
			if (bl1.getBanEntries().contains(target)) {
				Date created = bl1.getBanEntry(target.getName()).getCreated();
				Date expiry = bl1.getBanEntry(target.getName()).getExpiration();
				String reason = bl1.getBanEntry(target.getName()).getReason();
				String source = bl1.getBanEntry(target.getName()).getSource();
				tell("&3Gracz &b" + target.getName() + " &3jest zbanowany &3&lna IP!");
				tell("&3Nadano: &b" + created);
				tell("&3Wygasa: &b" + expiry);
				tell("&3Powód: &b" + reason);
				tell("&3Nadał: &b" + source);
			} else if (bl0.getBanEntries().contains(target)) {
				Date created = bl1.getBanEntry(target.getName()).getCreated();
				Date expiry = bl1.getBanEntry(target.getName()).getExpiration();
				String reason = bl1.getBanEntry(target.getName()).getReason();
				String source = bl1.getBanEntry(target.getName()).getSource();
				tell("&3Gracz &b" + target.getName() + " &3jest zbanowany!");
				tell("&3Nadano: &b" + created);
				tell("&3Wygasa: &b" + expiry);
				tell("&3Powód: &b" + reason);
				tell("&3Nadał: &b" + source);
			} else {
				tell("&3Gracz &b" + target.getName() + "&3 nie jest zbanowany.");
			}
		}
	}
}
