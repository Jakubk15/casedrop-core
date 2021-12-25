package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {

	public FeedCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.feed")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setFoodLevel(20);
					target.sendMessage(Util.color("&3Zostałeś najedzony!"));
					sender.sendMessage(Util.color("&3Najadłeś gracza " + target.getName() + "."));
					return true;
				} else {
					Player sender1 = (Player) sender;
					sender1.setFoodLevel(20);
					sender.sendMessage(Util.color("&3Zostałeś najedzony!"));
					return true;
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
			}
	return false;
}
}
