package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class NickCommand extends SimpleCommand {

	public NickCommand() {
		super("nick|nickname");
		setPermission("essentials.nick");
		setUsage("<player> <nickname>");
		setDescription("Change nickname of player.");
		setMinArguments(1);
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, Lang.of("Commands.NickProvide"));
		Player target = Bukkit.getPlayerExact(args[1]);
		if (target == null) return;
		target.setDisplayName(Common.colorize(args[0]));
		sender.sendMessage(Common.colorize("&3Zmieniono nick gracza " + target.getName() + " na " + Common.colorize(args[0])));
		sender.sendMessage(Common.colorize(Lang.of("Commands.NickChanged")
				.replace("{target}", target.getName())
				.replace("{nickname}", Common.colorize(args[0]))));

	}
}
