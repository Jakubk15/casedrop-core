package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class AnvilCommand extends SimpleCommand {

	public AnvilCommand() {
		super("anvil");
	}

	@Override
	public void onCommand() {
		if (sender instanceof Player p) {
			if (sender.hasPermission("essentials.anvil")) {
				p.openAnvil(null, true);
				return;
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień."));
				return;
			}
		} else {
			sender.sendMessage("Nie można wykonać tego polecenia z poziomu konsoli.");
		}
	}
}
