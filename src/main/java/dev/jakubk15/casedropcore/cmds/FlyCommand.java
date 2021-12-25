package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

	public FlyCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.fly")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setAllowFlight(!target.isFlying());
					Player sender1 = (Player) sender;
					target.sendMessage(Util.color("&3Latanie zostało:") + (sender1.getAllowFlight() ? "włączone." : "wyłączone."));
					return true;
				} else {
					Player sender1 = (Player) sender;
					sender1.setAllowFlight(!sender1.isFlying());
					sender.sendMessage(Util.color("&3Latanie zostało:") + (sender1.getAllowFlight() ? "włączone." : "wyłączone."));
					return true;
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień."));
			}
	return false;
	}
}
