package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class EnderChestCommand extends SimpleCommand {

	public EnderChestCommand() {
		super("enderchest|ec");
		setMinArguments(0);
		setPermission("essentials.enderchest");
		setDescription("Opens enderchest.");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkConsole();
		if (args.length > 0) {
			Player player = Bukkit.getPlayer(args[0]);
			if (player == null) {
				tell(Lang.of("Commands.Invalid_PlayerNickName"));
			}
			player.openInventory(player.getEnderChest());
			tell("&bOtworzono enderchest graczowi &3" + player.getName());
		} else {
			((Player) sender).openInventory(((Player) sender).getEnderChest());
		}
	}
}
