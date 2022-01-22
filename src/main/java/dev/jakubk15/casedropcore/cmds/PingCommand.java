package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.CasedropCore;
import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class PingCommand extends SimpleCommand {

	public PingCommand() {
		super("ping");
		setPermission("essentials.ping");
		setUsage("<player> <message>");
		setDescription("Sends a private message to player.");
	}

	@Override
	public void onCommand() {
		if (!(sender instanceof ConsoleCommandSender)) {
			Player sender1 = (Player) sender;
			for (int i = 0; i < 30; i++) {
				Bukkit.getScheduler().scheduleSyncRepeatingTask(CasedropCore.getInstance(), () -> sender.sendMessage(Util.color("&aTwój ping to: &6" + sender1.getPing())), 50, 1);
			}
		}
	}
}
