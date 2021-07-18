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
		Player p = (Player) sender;
		if (p.hasPermission("essentials.heal")) {
			if (args[0] != null) {
				Player cel = Bukkit.getPlayerExact(args[0]);
				cel.setHealth(20);
				cel.setFoodLevel(20);
				cel.setFireTicks(0);
				cel.sendMessage(ChatColorUtil.fixColor("&3Zostałeś uleczony!"));
				p.sendMessage(ChatColorUtil.fixColor("&3Uleczyłeś gracza " + cel.getName() + "."));
			} else {
				p.setHealth(20);
				p.setFoodLevel(20);
				p.setFireTicks(0);
				p.sendMessage(ChatColorUtil.fixColor("&3Zostałeś uleczony!"));
			}
		} else {
			p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnień!"));
		}
		return false;
	}
}
