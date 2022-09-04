package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.mineacademy.fo.command.SimpleCommand;

public class GrindstoneCommand extends SimpleCommand {

	public GrindstoneCommand() {
		super("grindstone");
		setMinArguments(0);
		setPermission("essentials.grindstone");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkConsole();
		Inventory inv = Bukkit.createInventory(null, InventoryType.GRINDSTONE);
		((Player) sender).openInventory(inv);
		tell("Commands.Grindstone_Successful");
	}
}
