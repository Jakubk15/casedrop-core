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
		checkConsole();
		((Player) sender).openStonecutter(null, true);
	}
}
