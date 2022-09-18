package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

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
		checkArgs(1, Lang.of("Commands.Invalid_PlayerNickName"));
		Player p = getPlayer();
		if (args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				tell(Lang.of("Invalid_PlayerNickName"));
			}
			p.teleport(target.getLocation());
			tell(Lang.of("Commands.Teleport_To")
					.replace("{player}", target.getName()));
		} else {
			Player target0 = Bukkit.getPlayer(args[0]);
			Player target1 = Bukkit.getPlayer(args[1]);
			target0.teleport(target1.getLocation());
			Common.tell(target0, Lang.of("Commands.Teleport_To")
					.replace("{player}", target1.getName()));
		}
	}
}
