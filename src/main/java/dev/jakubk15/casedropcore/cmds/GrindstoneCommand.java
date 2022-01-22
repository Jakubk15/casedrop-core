package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class GrindstoneCommand extends SimpleCommand {

	public GrindstoneCommand() {
		super("grindstone");
		setMinArguments(0);
		setPermission("essentials.grindstone");
	}

	@Override
	public void onCommand() {
		if (sender instanceof Player p) {
			if (sender.hasPermission("essentials.grindstone")) {
				p.openGrindstone(null, true);
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień."));
			}
		} else {
			sender.sendMessage("Nie można wykonać tego polecenia z poziomu konsoli.");
		}
	}
}
