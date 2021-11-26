package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.heal")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setHealth(20);
					target.setFoodLevel(20);
					target.setFireTicks(0);
					target.sendMessage(ChatColorUtil.fixColor("&3Zostałeś uleczony!"));
					sender.sendMessage(ChatColorUtil.fixColor("&3Uleczyłeś gracza " + target.getName() + "."));
				} else {
					Player sender1 = (Player) sender;
					sender1.setHealth(20);
					sender1.setFoodLevel(20);
					sender1.setFireTicks(0);
					sender.sendMessage(ChatColorUtil.fixColor("&3Zostałeś uleczony!"));
				}
			} else {
				sender.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
			}
		return false;
	}
}
