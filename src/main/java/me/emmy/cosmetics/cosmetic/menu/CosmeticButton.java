package me.emmy.cosmetics.cosmetic.menu;

import lombok.AllArgsConstructor;
import me.emmy.cosmetics.CosmeticsPlugin;
import me.emmy.cosmetics.api.menu.Button;
import me.emmy.cosmetics.cosmetic.AbstractCosmetic;
import me.emmy.cosmetics.profile.Profile;
import me.emmy.cosmetics.util.CC;
import me.emmy.cosmetics.util.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
@AllArgsConstructor
public class CosmeticButton extends Button {
    private final AbstractCosmetic cosmetic;

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(this.cosmetic.getMaterial())
                .name(this.cosmetic.getDisplayName())
                .lore(this.cosmetic.getDescription())
                .durability(this.cosmetic.getDurability())
                .build();
    }

    @Override
    public void clicked(Player player, ClickType clickType) {
        if (clickType != ClickType.LEFT) return;

        Profile profile = CosmeticsPlugin.getInstance().getProfileRepository().getProfile(player.getUniqueId());
        if (profile.getSelectedCosmetic().equals(this.cosmetic.getName())) {
            profile.setSelectedCosmetic("");
            player.sendMessage(CC.translate("&aYou have deselected the cosmetic: " + this.cosmetic.getDisplayName()));
            return;
        }

        if (!player.hasPermission(this.cosmetic.getPermission())) {
            player.sendMessage(CC.translate("&cYou do not have permission to use this cosmetic!"));
            return;
        }

        player.sendMessage(CC.translate("&aYou have selected the cosmetic: " + this.cosmetic.getName()));
        profile.setSelectedCosmetic(this.cosmetic.getName());
        player.closeInventory();
    }
}