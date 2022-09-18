package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.mineacademy.fo.command.SimpleCommand;

public class StoneCutterCommand extends SimpleCommand {

	public StoneCutterCommand() {
		super("stonecutter|sc");
		setPermission("essentials.stonecutter");
		setDescription("Opens a stonecutter.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkConsole();
		Inventory inv = Bukkit.createInventory(null, InventoryType.STONECUTTER);
		((Player) sender).openInventory(inv);
	}
}
