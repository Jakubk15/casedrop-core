package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class NickCommand extends SimpleCommand {

	public NickCommand() {
		super("nick|nickname");
		setPermission("essentials.nick");
		setUsage("<player> <nickname>");
		setDescription("Change nickname of player.");
		setMinArguments(1);
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayerExact(args[1]);
			if (target == null) return;
			target.displayName(Component.text(args[0]));
			sender.sendMessage(Util.color("&3Zmieniono nick gracza " + target.getName() + " na " + args[0]));
		} else {
			sender.sendMessage(Util.color("&cPodaj nowy nick!"));
		}
	}
}
