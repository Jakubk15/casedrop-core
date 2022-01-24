package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
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
		Inventory inv = Bukkit.createInventory(null, InventoryType.ANVIL);
		if (args.length > 0) {
			Player p = Bukkit.getPlayerExact(args[0]);
			p.openInventory(inv);
			tell("&bOtworzono kowadło graczowi &3" + p.getName());
		} else {
			((Player) sender).openInventory(inv);
		}
	}
}
