package dev.jakubk15.casedropcore.cmds;

import dev.jakubk15.casedropcore.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/*   WARNING!
 *    This command is in beta phase!
 *    It can cause lots of errors,
 *    And many lags!
 *    Use carefully, only when really needed.
 */
public class FreezeCommand implements CommandExecutor, Listener {

	public FreezeCommand() {}

	public static Set<UUID> freezedPlayers = new HashSet<>();

	@EventHandler
	private void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (freezedPlayers.contains(p.getUniqueId())) {
			e.setCancelled(true);
			p.sendMessage(Util.color("&cJesteś zamrożony! Nie możesz wykonywać żadnych akcji, HAHA!"));
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
				en.sendMessage(Util.color("&cJesteś zamrożony! Nie możesz wykonywać żadnych akcji, HAHA!"));
			}
		}

		/*
		 * Wykonywane gdy inny gracz zaatakuje zamrożonego gracza
		 */
		if (e.getDamager() instanceof Player) {
			Entity en = e.getEntity();
			if (freezedPlayers.contains(e.getEntity().getUniqueId())) {
				e.setCancelled(true);
				en.sendMessage(Util.color("&cTen gracz jest zamrożony, więc nie możesz zadawać mu żadnych obrażeń!"));
			}
		}
	}

	@EventHandler
	private void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (freezedPlayers.contains(p.getUniqueId())) {
			p.sendMessage(Util.color("&cJesteś zamrożony! Nie możesz wykonywać żadnych akcji, HAHA!"));
		}

	}

	@EventHandler
	private void onPickup(PlayerAttemptPickupItemEvent e) {
		Player p = e.getPlayer();
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
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender.hasPermission("essentials.freeze")) {
			if (args.length > 0) {
					if (args[1].equals("on")) {
						Player target = Bukkit.getPlayerExact(args[0]);
						assert target != null;
						if (!target.hasPermission("essentials.freeze.bypass")) {
							UUID uuid = target.getUniqueId();
							freezedPlayers.add(uuid);
							sender.sendMessage(Util.color("&3Zamrożono gracza " + target.getName()));
							target.sendMessage(Util.color("&3Gracz " + sender.getName() + "&3 zamroził cię."));
							target.setInvulnerable(!target.isInvulnerable());
							final int food = target.getFoodLevel();
							return true;
						} else {
							sender.sendMessage(Util.color("&cTen gracz ma uprawnienie 'essentials.freeze.bypass', co daje mu bypass na zamrażanie"));
							return false;
						}
					} else if (args[1].equals("off")) {
						Player cel = Bukkit.getPlayerExact(args[0]);
						UUID uuid = cel.getUniqueId();
						freezedPlayers.remove(uuid);
						sender.sendMessage(Util.color("&3Odmrożono gracza " + cel.getName()));
						cel.setInvulnerable(!cel.isInvulnerable());
						return true;
					} else {
						sender.sendMessage(Util.color("&cPodaj odpowiedni parametr; Dostępne: 'on', 'off'"));
						return false;
					}
			} else {
				sender.sendMessage(Util.color("&cPodaj nick gracza!"));
				return false;
			}
		} else {
			sender.sendMessage(Util.color("&cBrak uprawnien!"));
		}
	return false;
	}
}
