package me.emmy.cosmetics.cosmetic.impl;

import me.emmy.cosmetics.cosmetic.AbstractCosmetic;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
public class CosmeticHeartsImpl extends AbstractCosmetic {

    /**
     * Constructor for the AbstractCosmetic class.
     *
     * @param name        The internal name of the cosmetic.
     * @param displayName The display name of the cosmetic.
     * @param description The description of the cosmetic.
     * @param permission  The permission required to use this cosmetic.
     * @param material    The material type of the cosmetic.
     * @param durability  The durability of the cosmetic item.
     */
    public CosmeticHeartsImpl(String name, String displayName, List<String> description, String permission, Material material, int durability) {
        super(name, displayName, description, permission, material, durability);
    }

    @Override
    public void execute(Player player) {
        Effect effect = Effect.HEART;
        player.getWorld().playEffect(player.getLocation(), effect, 3, 0);
    }
}
