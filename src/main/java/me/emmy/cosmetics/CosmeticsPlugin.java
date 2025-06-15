package me.emmy.cosmetics;

import lombok.Getter;
import me.emmy.cosmetics.cosmetic.CosmeticRepository;
import me.emmy.cosmetics.profile.ProfileRepository;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Cosmetics extends JavaPlugin {

    @Getter
    private static Cosmetics instance;

    private ProfileRepository profileRepository;
    private CosmeticRepository cosmeticRepository;

    @Override
    public void onEnable() {
        instance = this;

        this.profileRepository = new ProfileRepository();
        this.cosmeticRepository = new CosmeticRepository();
    }

    @Override
    public void onDisable() {

    }
}
