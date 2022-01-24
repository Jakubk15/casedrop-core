package dev.jakubk15.casedropcore.cmds;

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
		checkArgs(1, "&cPodaj nick gracza!");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target.isBanned()) {
			Bukkit.getServer().getBannedPlayers().remove(target);
		} else {
			tell("&cTen gracz nie jest zbanowany!");
		}


	}
}
