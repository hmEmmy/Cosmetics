package me.emmy.cosmetics.cosmetic;

import lombok.Getter;
import me.emmy.cosmetics.cosmetic.impl.CosmeticHeartsImpl;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
@Getter
public class CosmeticRepository {
    private final List<AbstractCosmetic> cosmetics;

    public CosmeticRepository() {
        this.cosmetics = new ArrayList<>();
        this.initializeCosmetics();
    }

    private void initializeCosmetics() {
        AbstractCosmetic heartsCosmetic = new CosmeticHeartsImpl(
                "hearts",
                "Hearts",
                Arrays.asList(
                        "&7Use this cosmetic to show your love!",
                        "&7It will display hearts around you."
                ),
                "cosmetics.hearts",
                Material.REDSTONE,
                0
        );

        this.cosmetics.add(heartsCosmetic);
    }

    /**
     * Retrieves a cosmetic by its name.
     *
     * @param name The name of the cosmetic.
     * @return The Cosmetic object if found, otherwise null.
     */
    public AbstractCosmetic getCosmetic(String name) {
        return this.cosmetics.stream()
                .filter(cosmetic -> cosmetic.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}