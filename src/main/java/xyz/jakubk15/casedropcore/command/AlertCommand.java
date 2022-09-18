package xyz.jakubk15.casedropcore.command;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.remain.Remain;
import org.mineacademy.fo.settings.Lang;

import java.util.List;

public class AlertCommand extends SimpleCommand {

	public AlertCommand() {
		super("alert");
		setMinArguments(2);
		setUsage("<type> <message>");
		setDescription("Sends alert with specified type and message to all players.");
		setPermission("essentials.broadcast");
		setPermissionMessage("&cBrak uprawnień.");
	}

	@Override
	public void onCommand() {
		checkArgs(1, Lang.of("Commands.Invalid_Alert_Type"));
		String type = args[0];
		String message = args[1];
		if (!type.equals("title") && !type.equals("actionbar") && !type.equals("chat")) {
			sender.sendMessage(Common.colorize(Lang.of("Commands.Invalid_Alert_Type")));
		} else if (args[0].equals("chat")) {
			for (Player ps : Remain.getOnlinePlayers()) {
				ps.sendMessage(Common.colorize(Lang.of("Commands.Alert_Header")));
				ps.sendMessage(Common.colorize(" "));
				ps.sendMessage(Common.colorize("          " + message + "          "));
				ps.sendMessage(Common.colorize(" "));
				ps.sendMessage(Common.colorize(Lang.of("Commands.Alert_Header")));
				return;
			}
		} else if (args[0].equals("title")) {
			for (Player ps : Remain.getOnlinePlayers()) {
				String title = (Common.colorize(Lang.of("Commands.Alert_Title")));
				String subTitle = (Common.colorize(message));
				ps.sendTitle(title, subTitle, 5, 40, 5);
				return;
			}
		} else if (args[0].equals("actionbar")) {
			for (Player ps : Remain.getOnlinePlayers()) {
				String actionbar = (Common.colorize(Lang.of("Commands.Alert_ActionBar") + message));
				ps.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
				return;
			}
		}


	}

	@Override
	protected List<String> completeLastWordPlayerNames() {
		return super.completeLastWordPlayerNames();
	}
}
