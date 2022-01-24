package dev.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class RealNameCommand extends SimpleCommand {


	public RealNameCommand() {
		super("realname");
		setMinArguments(1);
		setDescription("Sprawdza prawdziwą nazwę danego gracza, jeżeli jest znickowany.");
		setPermission("essentials.realname");
		setPermissionMessage("&cBrak uprawnień.");
	}


	@Override
	protected void onCommand() {
		checkArgs(1, "&cPodaj nick gracza, który chcesz sprawdzić");
		String param = args[0];
		Player p = Bukkit.getPlayer(param);
		if (!p.getDisplayName().equalsIgnoreCase(p.getName())) {
			String name = p.getName();
			tell("&3Prawdziwa nazwa gracza &b" + p.getDisplayName() + "&3 to &b" + p.getName());
		} else {
			tell("&3Ten gracz nie jest znickowany.");
		}
	}
}
