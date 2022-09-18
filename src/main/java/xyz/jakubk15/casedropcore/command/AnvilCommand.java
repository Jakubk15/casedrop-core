package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class AnvilCommand extends SimpleCommand {

	public AnvilCommand() {
		super("anvil");
		setMinArguments(0);
		setDescription("Opens anvil");
		setPermission("essentials.anvil");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkConsole();
		Inventory inv = Bukkit.createInventory(null, InventoryType.ANVIL);
		if (args.length > 0) {
			Player player = Bukkit.getPlayerExact(args[0]);
			if (player == null) tell(Lang.of("Commands.Invalid_PlayerNickName"));
			if (player != null) {
				player.openInventory(inv);
			}
			tell(Lang.of("Commands.Anvil_Successful").replace("{player}", player.getName()));
		} else {
			((Player) sender).openInventory(inv);
		}
	}
}
