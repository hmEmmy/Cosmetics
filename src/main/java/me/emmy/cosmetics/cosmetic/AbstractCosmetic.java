package me.emmy.cosmetics.cosmetic;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
@Getter
@Setter
public abstract class AbstractCosmetic {
    private final String name;
    private final String displayName;
    private final List<String> description;

    private final String permission;

    private final Material material;
    private final int durability;

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
    public AbstractCosmetic(String name, String displayName, List<String> description, String permission, Material material, int durability) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.permission = permission;
        this.material = material;
        this.durability = durability;
    }

    /**
     * Executes the cosmetic action for the given player.
     *
     * @param player The player who is using the cosmetic.
     */
    public abstract void execute(Player player);
}