package xyz.jakubk15.casedropcore.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.settings.Lang;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/*   WARNING!
 *    This command is in beta phase!
 *    It can cause lots of errors,
 *    And many lags!
 *    Use carefully, only when really needed.
 */
public class FreezeCommand extends SimpleCommand implements Listener {

	public FreezeCommand() {
		super("freeze");
		setMinArguments(1);
		setUsage("<player>");
		setPermission("essentials.freeze");
		setPermissionMessage("&cBrak uprawnień.");
	}

	public static Set<UUID> freezedPlayers = new HashSet<>();


	/*
	 *
	 * Wywołuje bardzo duże lagi. Używaj na własną odpowiedzialność.
	 * Może zostać usunięte w przyszłości.
	 *
	 */


	@Deprecated
	@EventHandler
	private void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (freezedPlayers.contains(p.getUniqueId())) {
			e.setCancelled(true);
			p.sendMessage(Common.colorize(Lang.of("Commands.FreezeAction")));
		}
	}

	/*
	 * Wykonywane gdy zamrożony gracz zaatakuje innego gracza
	 */
	@EventHandler
	private void onAttack(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Entity en = e.getDamager();
			if (freezedPlayers.contains(en.getUniqueId())) {
				e.setCancelled(true);
				en.sendMessage(Common.colorize(Lang.of("Commands.FreezeAction")));
			}
		}

		/*
		 * Wykonywane gdy inny gracz zaatakuje zamrożonego gracza
		 */
		if (e.getDamager() instanceof Player) {
			Entity en = e.getEntity();
			if (freezedPlayers.contains(e.getEntity().getUniqueId())) {
				e.setCancelled(true);
				en.sendMessage(Common.colorize(Lang.of("Commands.FreezeOther")));
			}
		}
	}

	@EventHandler
	private void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (freezedPlayers.contains(p.getUniqueId())) {
			p.sendMessage(Common.colorize(Lang.of("Commands.FreezeAction")));
		}

	}

	@EventHandler
	private void onPickup(EntityPickupItemEvent e) {
		Player p = (Player) e.getEntity();
		if (freezedPlayers.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	private void onFoodDrain(FoodLevelChangeEvent e) {
		if (e.getEntity() instanceof Player) {
			if (freezedPlayers.contains(((Player) e.getEntity()).getPlayer().getUniqueId())) {
				e.setCancelled(true);
			}
		}
	}


	@Override
	public void onCommand() {
		checkArgs(1, Lang.of("Commands.Invalid_PlayerNickName"));
		if (args[1].equals("on")) {
			Player target = Bukkit.getPlayerExact(args[0]);
			assert target != null;
			if (!target.hasPermission("essentials.freeze.bypass")) {
				UUID uuid = target.getUniqueId();
				freezedPlayers.add(uuid);
				sender.sendMessage(Common.colorize(Lang.of("Commands.Freezed").replace("{player}", target.getName())));
				target.sendMessage(Common.colorize(Lang.of("Commands.Frozen").replace("{admin}", sender.getName())));
				target.setInvulnerable(!target.isInvulnerable());
			} else {
				sender.sendMessage(Common.colorize(Lang.of("Commands.FreezeBypass")));
			}
		} else if (args[1].equals("off")) {
			Player cel = Bukkit.getPlayerExact(args[0]);
			UUID uuid = cel.getUniqueId();
			freezedPlayers.remove(uuid);
			sender.sendMessage(Common.colorize(Lang.of("Commands.Freezed_disabled")));
			cel.setInvulnerable(!cel.isInvulnerable());
		} else {
			sender.sendMessage(Common.colorize(Lang.of("Commands.Freeze_Parameter")));
		}
	}
}
