package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NickCommand implements CommandExecutor {

	public NickCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.nick")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[1]);
					assert target != null;
					target.displayName(Component.text(args[0]));
					sender.sendMessage(Util.color("&3Zmieniono nick gracza " + target.getName() + " na " + args[0]));
				} else {
					sender.sendMessage(Util.color("&cPodaj nowy nick!"));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
			}

		return false;
	}
}
