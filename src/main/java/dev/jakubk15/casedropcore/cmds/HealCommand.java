package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

	public HealCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.heal")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setHealth(20);
					target.setFoodLevel(20);
					target.setFireTicks(0);
					target.sendMessage(Util.color("&3Zostałeś uleczony!"));
					sender.sendMessage(Util.color("&3Uleczyłeś gracza " + target.getName() + "."));
					return true;
				} else {
					Player sender1 = (Player) sender;
					sender1.setHealth(20);
					sender1.setFoodLevel(20);
					sender1.setFireTicks(0);
					sender.sendMessage(Util.color("&3Zostałeś uleczony!"));
					return true;
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
			}
		return false;
	}
}
