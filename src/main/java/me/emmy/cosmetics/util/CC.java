package me.emmy.cosmetics.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
@UtilityClass
public class CC {
    public String MENU_BAR = ChatColor.GRAY + "--------------------";

    /**
     * Translates the given message by replacing '&' with '§' and applying color codes.
     *
     * @param message The message to translate.
     * @return The translated message with color codes applied.
     */
    public String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}