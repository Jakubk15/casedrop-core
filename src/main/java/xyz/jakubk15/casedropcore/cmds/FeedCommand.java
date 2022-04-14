package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

public class FeedCommand extends SimpleCommand {

	public FeedCommand() {
		super("feed");
		setMinArguments(0);
		setDescription("Feeds player.");
		setPermission("essentials.feed");
		setUsage("[player]");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayerExact(args[0]);
			if (target == null) return;
			target.setFoodLevel(20);
			target.sendMessage(Common.colorize(Lang.of("Commands.Feed")));
			tell(Common.colorize(Lang.of("Feed_Other").replace("{player}", target.getName())));
		} else {
			Player sender1 = (Player) sender;
			sender1.setFoodLevel(20);
			tell(Common.colorize(Lang.of("Commands.Feed")));
		}
	}
}
