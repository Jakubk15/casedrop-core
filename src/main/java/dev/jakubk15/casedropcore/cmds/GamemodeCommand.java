package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.ChatColorUtil;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("essentials.gamemode")) {
			if (args[0] != null) {
				if (args[0] == "0") {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(ChatColorUtil.fixColor("&3Twój tryb gry został zmieniony na " + p.getGameMode()));
				} else if (args[0] == "1") {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(ChatColorUtil.fixColor("&3Twój tryb gry został zmieniony na " + p.getGameMode()));
				} else if (args[0] == "2") {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(ChatColorUtil.fixColor("&3Twój tryb gry został zmieniony na " + p.getGameMode()));
				} else if (args[0] == "3") {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage(ChatColorUtil.fixColor("&3Twój tryb gry został zmieniony na " + p.getGameMode()));
				}
			} else {
				p.sendMessage(ChatColorUtil.fixColor("&cPodaj argument 1!"));
			}
		} else {
			p.sendMessage(ChatColorUtil.fixColor("&cBrak uprawnien!"));
		}
		return false;
	}
}
