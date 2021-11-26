package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.feed")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setFoodLevel(20);
					target.sendMessage(ChatColorUtil.fixColor("&3Zostałeś najedzony!"));
					sender.sendMessage(ChatColorUtil.fixColor("&3Najadłeś gracza " + target.getName() + "."));
				} else {
					Player sender1 = (Player) sender;
					sender1.setFoodLevel(20);
					sender.sendMessage(ChatColorUtil.fixColor("&3Zostałeś najedzony!"));
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
			}
	return false;
}
}
