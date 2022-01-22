package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class FeedCommand extends SimpleCommand {

	public FeedCommand() {
		super("feed");
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.feed")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setFoodLevel(20);
					target.sendMessage(Util.color("&3Zostałeś najedzony!"));
					sender.sendMessage(Util.color("&3Najadłeś gracza " + target.getName() + "."));
				} else {
					Player sender1 = (Player) sender;
					sender1.setFoodLevel(20);
					sender.sendMessage(Util.color("&3Zostałeś najedzony!"));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
			}
	}
}
