package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class UnbanCommand extends SimpleCommand {

	public UnbanCommand() {
		super("unban");
		setPermission("essentials.unban");
		setDescription("Unbans a already banned player.");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayerExact(args[0]);
			assert target != null;
			if (target.isBanned()) {
				Bukkit.getServer().getBannedPlayers().remove(target);
			} else {
				sender.sendMessage(Util.color("&cTen gracz nie jest zbanowany!"));
			}
		} else {
			sender.sendMessage(Util.color("&cPodaj nick gracza!"));
		}

	}
}
