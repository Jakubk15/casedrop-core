package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class UnmuteCommand extends SimpleCommand {

	public UnmuteCommand() {
		super("unmute");
		setPermission("essentials.unmute");
		setUsage("<player>");
		setDescription("Unmutes already muted player.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj nick gracza!");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) return;
		if (MuteCommand.muted.contains(target.getUniqueId())) {
			MuteCommand.muted.remove(target.getUniqueId());
			tell("&3Odciszono gracza " + target.getName());
		} else {
			tell("&cTen gracz nie jest wyciszony!");
		}
	}
}
