package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class GamemodeCommand extends SimpleCommand {

	public GamemodeCommand() {
		super("gamemode|gm");
		setMinArguments(1);
		setPermission("essentials.gamemode");
		setDescription("Changes gamemode.");
		setUsage("<gamemode>");
	}

	@Override
	public void onCommand() {
		if (args.length > 0) {
			Player sender1 = (Player) sender;
			if (sender1 == null) return;
			switch (args[0]) {
				case "0" -> {
					sender1.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage(Util.color("&3Twój tryb gry został zmieniony na " + sender1.getGameMode()));
				}
				case "1" -> {
					sender1.setGameMode(GameMode.CREATIVE);
					sender.sendMessage(Util.color("&3Twój tryb gry został zmieniony na " + sender1.getGameMode()));
				}
				case "2" -> {
					sender1.setGameMode(GameMode.ADVENTURE);
					sender.sendMessage(Util.color("&3Twój tryb gry został zmieniony na " + sender1.getGameMode()));
				}
				case "3" -> {
					sender1.setGameMode(GameMode.SPECTATOR);
					sender.sendMessage(Util.color("&3Twój tryb gry został zmieniony na " + sender1.getGameMode()));
				}
			}
		} else {
			sender.sendMessage(Util.color("&cPodaj argument 1!"));
		}
	}

}
