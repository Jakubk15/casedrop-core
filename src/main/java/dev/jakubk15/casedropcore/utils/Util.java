package dev.jakubk15.casedropcore.utils;

import org.bukkit.ChatColor;

public class Util {

	public Util() {}

	public static String color(final String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
}
