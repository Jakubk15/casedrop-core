package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import xyz.jakubk15.casedropcore.CasedropCore;

public class PingCommand extends SimpleCommand {

	public PingCommand() {
		super("ping");
		setPermission("essentials.ping");
		setUsage("<player> <message>");
		setDescription("Check player ping.");
	}

	@Override
	public void onCommand() {
		checkConsole();
		Player sender1 = getPlayer();
		for (int i = 0; i < 10; i++) {
			Bukkit.getScheduler().scheduleSyncRepeatingTask(CasedropCore.getInstance(),
					() -> sender.sendMessage(Common.colorize("Commands.Ping").replace("{ping}", Integer.toString(sender1.getPing()))), 200, 1);
		}
	}
}
