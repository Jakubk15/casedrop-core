package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class HealCommand extends SimpleCommand {

	public HealCommand() {
		super("heal");
	}

	@Override
	public void onCommand() {
			if (sender.hasPermission("essentials.heal")) {
				if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					assert target != null;
					target.setHealth(20);
					target.setFoodLevel(20);
					target.setFireTicks(0);
					target.sendMessage(Util.color("&3Zostałeś uleczony!"));
					sender.sendMessage(Util.color("&3Uleczyłeś gracza " + target.getName() + "."));
				} else {
					Player sender1 = (Player) sender;
					sender1.setHealth(20);
					sender1.setFoodLevel(20);
					sender1.setFireTicks(0);
					sender.sendMessage(Util.color("&3Zostałeś uleczony!"));
				}
			} else {
				sender.sendMessage(Util.color("&cBrak uprawnień!"));
			}
	}
}
