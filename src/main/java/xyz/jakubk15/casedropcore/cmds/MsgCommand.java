package xyz.jakubk15.casedropcore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.Lang;

public class MsgCommand extends SimpleCommand {

	public MsgCommand() {
		super("msg|message|whisper|tell");
		setPermission("essentials.msg");
		setUsage("<player> <message>");
		setDescription("Sends a private message to player.");
		setMinArguments(2);
	}

	@Override
	public void onCommand() {
		checkArgs(1, "&cPodaj nick gracza");
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target != null) {
			String msg = args[1];
			target.sendMessage(Common.colorize(Lang.of("Commands.MsgFormat")
					.replace("{sender}", sender.getName())
					.replace("{target}", target.getName())));
			
			tell(Common.colorize(Lang.of("Commands.MsgFormat")
					.replace("{sender}", sender.getName())
					.replace("{target}", target.getName())));
			// TODO implement config socialspy check
			for (Player adm : Remain.getOnlinePlayers()) {
				if (adm.hasPermission("essentials.socialspy")) {
					adm.sendMessage(Common.colorize("&4[SocialSpy] &3[&b" + sender.getName() + "&3 -> " + target.getName() + "&3] &7" + msg));
				}
			}
		} else {
			sender.sendMessage(Common.colorize("&cPodany gracz jest offline lub nie był nigdy na serwerze!"));
		}
	}
}
