package dev.jakubk15.casedropcore.utils;

import org.bukkit.ChatColor;

public class ChatColorUtil {

	public static String fixColor(final String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
}
