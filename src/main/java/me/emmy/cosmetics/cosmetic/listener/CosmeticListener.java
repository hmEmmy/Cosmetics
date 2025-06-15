package me.emmy.cosmetics.cosmetic.listener;

import me.emmy.cosmetics.CosmeticsPlugin;
import me.emmy.cosmetics.cosmetic.AbstractCosmetic;
import me.emmy.cosmetics.cosmetic.CosmeticRepository;
import me.emmy.cosmetics.profile.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
public class CosmeticListener implements Listener {
    protected final CosmeticsPlugin plugin;

    /**
     * Constructor for the CosmeticListener class.
     *
     * @param plugin The instance of the Cosmetics plugin.
     */
    public CosmeticListener(CosmeticsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Profile profile = this.plugin.getProfileRepository().getProfile(player.getUniqueId());
        if (profile == null) return;
        if (profile.getSelectedCosmetic() == null) return;
        if (profile.getSelectedCosmetic().isEmpty() || !player.hasPermission(profile.getSelectedCosmetic())) return;

        CosmeticRepository cosmeticRepository = this.plugin.getCosmeticRepository();
        AbstractCosmetic cosmetic = cosmeticRepository.getCosmetic(profile.getSelectedCosmetic());
        cosmetic.execute(player);
    }
}