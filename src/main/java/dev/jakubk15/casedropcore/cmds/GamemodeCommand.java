package dev.jakubk15.casedropcore.cmds;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class GamemodeCommand extends SimpleCommand {

	public GamemodeCommand() {
		super("gamemode|gm");
		setMinArguments(1);
		setPermission("essentials.gamemode");
		setDescription("Changes gamemode.");
		setUsage("<gamemode>");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj argument 1");
		Player sender1 = (Player) sender;
		if (sender1 == null) return;
		switch (args[0]) {
			case "0": {
				sender1.setGameMode(GameMode.SURVIVAL);
				sender.sendMessage(Common.colorize("&3Twój tryb gry został zmieniony na " + sender1.getGameMode()));
			}
			case "1": {
				sender1.setGameMode(GameMode.CREATIVE);
				sender.sendMessage(Common.colorize("&3Twój tryb gry został zmieniony na " + sender1.getGameMode()));
			}
			case "2": {
				sender1.setGameMode(GameMode.ADVENTURE);
				sender.sendMessage(Common.colorize("&3Twój tryb gry został zmieniony na " + sender1.getGameMode()));
			}
			case "3": {
				sender1.setGameMode(GameMode.SPECTATOR);
				sender.sendMessage(Common.colorize("&3Twój tryb gry został zmieniony na " + sender1.getGameMode()));
			}
		}
	}

}
