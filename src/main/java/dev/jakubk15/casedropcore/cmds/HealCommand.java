package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class HealCommand extends SimpleCommand {

	public HealCommand() {
		super("heal");
		setMinArguments(0);
		setUsage("[player]");
		setDescription("Heals player.");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player target = Bukkit.getPlayerExact(args[0]);
			if (target == null) return;
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
	}
}
