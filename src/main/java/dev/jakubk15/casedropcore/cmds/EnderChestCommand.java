package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class EnderChestCommand extends SimpleCommand {

	public EnderChestCommand() {
		super("enderchest|ec");
	}

	@Override
	public void onCommand() {
		if (sender instanceof Player p) {
			if (sender.hasPermission("essentials.enderchest")) {
				p.openInventory(p.getEnderChest());
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień."));
			}
		} else {
			sender.sendMessage("Nie można wykonać tego polecenia z poziomu konsoli.");
		}
	}
}
