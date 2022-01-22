package dev.jakubk15.casedropcore.cmds;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class StoneCutterCommand extends SimpleCommand {

	public StoneCutterCommand() {
		super("stonecutter|sc");
		setPermission("essentials.stonecutter");
		setDescription("Opens a stonecutter.");
	}

	@Override
	public void onCommand() {
		if (sender instanceof Player p) {
			p.openStonecutter(null, true);
		} else {
			sender.sendMessage("Nie można wykonać tego polecenia z poziomu konsoli.");
		}
	}
}
