package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class UnbanCommand extends SimpleCommand {

	public UnbanCommand() {
		super("unban");
		setPermission("essentials.unban");
		setDescription("Unbans a already banned player.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj nick gracza!");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target.isBanned()) {
			Bukkit.getServer().getBannedPlayers().remove(target);
			tell(Lang.of("Commands.Unbanned"));
		} else {
			tell("&cTen gracz nie jest zbanowany!");
		}


	}
}
