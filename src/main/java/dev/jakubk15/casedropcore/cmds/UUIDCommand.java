package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class UUIDCommand extends SimpleCommand {

	public UUIDCommand() {
		super("uuid|getuuid");
	}

	@Override
	public void onCommand() {
			if (args.length > 0) {
				Player target = Bukkit.getPlayerExact(args[0]);
				assert target != null;
				sender.sendMessage(Util.color("&3UUID gracza &b" + target.getName() + "&3 to &b" + target.getUniqueId()));
			} else {
				sender.sendMessage(Util.color("&cPodaj prawidłowy nick gracza"));
			}
	}
}
