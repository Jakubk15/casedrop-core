package xyz.jakubk15.casedropcore.command;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

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
		checkArgs(1, Common.colorize(Lang.of("Gamemode_Provide_Parameter")));
		Player sender1 = (Player) sender;
		if (sender1 == null) return;
		switch (args[0]) {
			case "0": {
				sender1.setGameMode(GameMode.SURVIVAL);
				sender.sendMessage(Common.colorize(Lang.of("Gamemode_Changed").replace("{gamemode}", sender1.getGameMode().name())));
			}
			case "1": {
				sender1.setGameMode(GameMode.CREATIVE);
				sender.sendMessage(Common.colorize(Lang.of("Gamemode_Changed").replace("{gamemode}", sender1.getGameMode().name())));
			}
			case "2": {
				sender1.setGameMode(GameMode.ADVENTURE);
				sender.sendMessage(Common.colorize(Lang.of("Gamemode_Changed").replace("{gamemode}", sender1.getGameMode().name())));
			}
			case "3": {
				sender1.setGameMode(GameMode.SPECTATOR);
				sender.sendMessage(Common.colorize(Lang.of("Gamemode_Changed").replace("{gamemode}", sender1.getGameMode().name())));
			}
		}
	}

}
