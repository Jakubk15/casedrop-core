package xyz.jakubk15.casedropcore.command;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

import java.util.Date;
import java.util.Objects;

public class CheckbanCommand extends SimpleCommand {

	public CheckbanCommand() {
		super("checkban|bancheck");
		setMinArguments(1);
		setUsage("<player>");
		setDescription("Check if player is banned.");
		setPermission("essentials.checkban");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	protected void onCommand() {
		checkArgs(1, Common.colorize(Lang.of("Commands.Checkban_Provide_name")));
		Player target = Bukkit.getPlayer(args[0]);
		assert target != null;
		if (target.isBanned()) {
			BanList bl0 = Bukkit.getBanList(BanList.Type.NAME);
			BanList bl1 = Bukkit.getBanList(BanList.Type.IP);
			if (bl1.getBanEntries().contains(target)) {
				Date created = Objects.requireNonNull(bl1.getBanEntry(target.getName())).getCreated();
				Date expiry = Objects.requireNonNull(bl1.getBanEntry(target.getName())).getExpiration();
				String reason = Objects.requireNonNull(bl1.getBanEntry(target.getName())).getReason();
				String source = Objects.requireNonNull(bl1.getBanEntry(target.getName())).getSource();
				tell(Lang.of("Commands.Checkban_IPBanned").replace("{player}", target.getName()));
				tell(Lang.of("Commands.Checkban_Created").replace("{created}", created.toString()));
				tell(Lang.of("Commands.Checkban_Expiry").replace("{expiry}", expiry != null ? expiry.toString() : "never"));
				tell(Lang.of("Commands.Checkban_Reason").replace("{reason}", reason != null ? reason : "none"));
				tell(Lang.of("Commands.Checkban_Source").replace("{source}", source));
			} else if (bl0.getBanEntries().contains(target)) {
				Date created = Objects.requireNonNull(bl1.getBanEntry(target.getName())).getCreated();
				Date expiry = Objects.requireNonNull(bl1.getBanEntry(target.getName())).getExpiration();
				String reason = Objects.requireNonNull(bl1.getBanEntry(target.getName())).getReason();
				String source = Objects.requireNonNull(bl1.getBanEntry(target.getName())).getSource();
				tell(Lang.of("Commands.Checkban_Banned").replace("{player}", target.getName()));
				tell(Lang.of("Commands.Checkban_Created").replace("{created}", created.toString()));
				tell(Lang.of("Commands.Checkban_Expiry").replace("{expiry}", expiry != null ? expiry.toString() : "never"));
				tell(Lang.of("Commands.Checkban_Reason").replace("{reason}", reason != null ? reason : "none"));
				tell(Lang.of("Commands.Checkban_Source").replace("{source}", source));
			} else {
				tell(Lang.of("Commands.Checkban_NotBanned").replace("{player}", target.getName()));
			}
		}
	}
}
