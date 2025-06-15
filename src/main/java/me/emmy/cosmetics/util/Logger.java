package me.emmy.cosmetics.util;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
@UtilityClass
public class Logger {
    private final String prefix = CC.translate("&8[&aCosmetics&8] &7");

    /**
     * Logs a message to the console with a prefix.
     *
     * @param message The message to log.
     */
    public void log(String message) {
        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "&a" + message));
    }

    /**
     * Logs an error message to the console with a prefix.
     *
     * @param message The error message to log.
     */
    public void logError(String message) {
        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "&c" + message));
    }
}