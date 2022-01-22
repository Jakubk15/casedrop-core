package dev.jakubk15.casedropcore.cmds;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class AnvilCommand extends SimpleCommand {

	public AnvilCommand() {
		super("anvil");
		setMinArguments(0);
		setDescription("Opens anvil");
		setPermission("essentials.anvil");
	}

	@Override
	public void onCommand() {
		checkConsole();
		((Player) sender).openAnvil(null, true);
	}
}
