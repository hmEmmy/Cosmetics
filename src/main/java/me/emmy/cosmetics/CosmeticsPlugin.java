package me.emmy.cosmetics;

import lombok.Getter;
import me.emmy.cosmetics.api.menu.MenuListener;
import me.emmy.cosmetics.cosmetic.CosmeticRepository;
import me.emmy.cosmetics.cosmetic.command.CosmeticsCommand;
import me.emmy.cosmetics.cosmetic.listener.CosmeticListener;
import me.emmy.cosmetics.profile.ProfileRepository;
import me.emmy.cosmetics.profile.listener.ProfileListener;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class CosmeticsPlugin extends JavaPlugin {

    @Getter
    private static CosmeticsPlugin instance;

    private ProfileRepository profileRepository;
    private CosmeticRepository cosmeticRepository;

    @Override
    public void onEnable() {
        instance = this;

        this.profileRepository = new ProfileRepository();
        this.cosmeticRepository = new CosmeticRepository();

        this.getServer().getPluginManager().registerEvents(new MenuListener(), this);
        this.getServer().getPluginManager().registerEvents(new ProfileListener(this), this);
        this.getServer().getPluginManager().registerEvents(new CosmeticListener(this), this);

        this.getCommand("cosmetics").setExecutor(new CosmeticsCommand());
    }

    @Override
    public void onDisable() {

    }
}
