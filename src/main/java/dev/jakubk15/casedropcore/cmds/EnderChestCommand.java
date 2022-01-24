package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
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
		if (args.length > 0) {
			Player player = Bukkit.getPlayer(args[0]);
			player.openInventory(player.getEnderChest());
			tell("&bOtworzono enderchest graczowi &3" + player.getName());
		} else {
			((Player) sender).openInventory(((Player) sender).getEnderChest());
		}
	}
}
