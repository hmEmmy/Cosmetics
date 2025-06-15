package me.emmy.cosmetics.profile;

import lombok.Data;
import org.bukkit.Bukkit;

import java.util.UUID;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
@Data
public class Profile {
    private final UUID uuid;
    private String username;

    private String selectedCosmetic;

    /**
     * Constructor for the Profile class.
     *
     * @param uuid The UUID of the player.
     */
    public Profile(UUID uuid) {
        this.uuid = uuid;
        this.username = Bukkit.getOfflinePlayer(uuid).getName();
        this.selectedCosmetic = "";
    }
}