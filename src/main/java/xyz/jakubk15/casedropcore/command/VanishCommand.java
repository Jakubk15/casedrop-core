package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class VanishCommand extends SimpleCommand {

	public VanishCommand() {
		super("vanish|v");
		setPermission("essentials.vanish");
		setUsage("<player>");
		setDescription("Włącza/wyłącza vanisha.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayerExact(args[0]);
			if (target == null) return;
			tell(target.isInvisible() ? Lang.of("Commands.VanishDisabledOther").replace("{player}", target.getName()) : Lang.of("Commands.VanishEnabledOther").replace("{player}", target.getName()));
			target.setInvisible(!target.isInvisible());
		} else {
			Player sender1 = (Player) sender;
			tell(sender1.isInvisible() ? Lang.of("Commands.VanishDisabled") : Lang.of("Commands.VanishEnabled"));
			sender1.setInvisible(!sender1.isInvisible());
		}
	}
}


