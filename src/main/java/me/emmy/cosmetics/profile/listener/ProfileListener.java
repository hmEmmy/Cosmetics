package me.emmy.cosmetics.profile.listener;

import me.emmy.cosmetics.CosmeticsPlugin;
import me.emmy.cosmetics.profile.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
public class ProfileListener implements Listener {
    protected final CosmeticsPlugin plugin;

    /**
     * Constructor for the ProfileListener class.
     *
     * @param plugin The instance of the Cosmetics plugin.
     */
    public ProfileListener(CosmeticsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        Profile profile = new Profile(player.getUniqueId());
        this.plugin.getProfileRepository().addProfile(profile);
    }

    @EventHandler
    private void onJoin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        Profile profile = this.plugin.getProfileRepository().getProfile(player.getUniqueId());
        if (profile != null) {
            profile.setUsername(player.getName());
        }
    }
}
