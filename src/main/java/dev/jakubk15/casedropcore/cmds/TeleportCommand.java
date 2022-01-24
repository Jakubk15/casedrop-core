package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class TeleportCommand extends SimpleCommand {

	public TeleportCommand() {
		super("tp|teleport|to");
		setMinArguments(1);
		setPermission("essentials.teleport");
		setPermissionMessage("&cBrak uprawnień.");
		setDescription("Teleportuje obiekt0 do obiektu1");
	}


	@Override
	protected void onCommand() {
		checkConsole();
		checkArgs(1, "&cPodaj nick gracza.");
		Player p = (Player) sender;
		if (args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				tell("&cAha. Szkoda, że tego gracza nie ma nawet na serwerze. Kogo mam przeteleportować? Powietrze?");
			}
			p.teleport(target.getLocation());
			tell("&3Zostałeś teleportowany do &b" + target.getName());
		} else {
			Player target0 = Bukkit.getPlayer(args[0]);
			Player target1 = Bukkit.getPlayer(args[1]);
			target0.teleport(target1.getLocation());
			target0.sendMessage("&3Zostałeś teleportowany do &b" + target1.getName());
		}
	}
}
