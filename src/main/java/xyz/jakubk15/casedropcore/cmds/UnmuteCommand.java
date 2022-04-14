package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class UnmuteCommand extends SimpleCommand {

	public UnmuteCommand() {
		super("unmute");
		setPermission("essentials.unmute");
		setUsage("<player>");
		setDescription("Unmutes already muted player.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj nick gracza!");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		if (MuteCommand.muted.contains(target.getUniqueId())) {
			MuteCommand.muted.remove(target.getUniqueId());
			tell(Lang.of("Commands.Unmuted")
					.replace("{player}", target.getName()));
		} else {
			tell(Lang.of("Commands.Unmuted_Fail"));
		}
	}
}
