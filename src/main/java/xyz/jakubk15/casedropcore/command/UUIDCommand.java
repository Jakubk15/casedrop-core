package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class UUIDCommand extends SimpleCommand {

	public UUIDCommand() {
		super("uuid|getuuid");
		setPermission("essentials.uuid");
		setUsage("<player>");
		setDescription("Gets UUID (Unique ID) of player.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, Lang.of("Commands.Invalid_PlayerNickName"));
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		tell(Lang.of("Commands.UUID")
				.replace("{player}", target.getName())
				.replace("{uuid}", target.getUniqueId().toString()));
	}
}
