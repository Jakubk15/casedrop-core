package dev.jakubk15.casedropcore.cmds;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class EnderChestCommand extends SimpleCommand {

	public EnderChestCommand() {
		super("enderchest|ec");
		setMinArguments(0);
		setPermission("essentials.enderchest");
		setDescription("Opens enderchest.");
		
	}

	@Override
	public void onCommand() {
		checkConsole();
		((Player) sender).openInventory(((Player) sender).getEnderChest());
	}
}
