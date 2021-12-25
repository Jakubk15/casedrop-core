package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodCommand implements CommandExecutor {

	public GodCommand() {}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
			if (sender.hasPermission("essentials.god")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setInvulnerable(!target.isInvulnerable());
					sender.sendMessage(Util.color("&3Godmode " + (target.isInvulnerable() ? "&3włączone" : "&3wyłączone")));
					return true;
				} else {
					Player sender1 = (Player) sender;
					sender1.setInvulnerable(!sender1.isInvulnerable());
					sender.sendMessage(Util.color("&3Godmode " + (sender1.isInvulnerable() ? "&3włączone" : "&3wyłączone")));
					return true;
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnien."));
			}
		return false;
		}
	}
