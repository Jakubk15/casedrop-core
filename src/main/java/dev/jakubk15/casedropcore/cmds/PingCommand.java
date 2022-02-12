package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.CasedropCore;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class PingCommand extends SimpleCommand {

	public PingCommand() {
		super("ping");
		setPermission("essentials.ping");
		setUsage("<player> <message>");
		setDescription("Check player ping.");
	}

	@Override
	public void onCommand() {
		if (!(sender instanceof ConsoleCommandSender)) {
			Player sender1 = (Player) sender;
			for (int i = 0; i < 30; i++) {
				Bukkit.getScheduler().scheduleSyncRepeatingTask(CasedropCore.getInstance(), () -> sender.sendMessage(Common.colorize("&aTwój ping to: &6" + sender1.getPing())), 50, 1);
			}
		}
	}
}
