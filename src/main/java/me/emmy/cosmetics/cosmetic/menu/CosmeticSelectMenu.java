package me.emmy.cosmetics.cosmetic.menu;

import me.emmy.cosmetics.api.menu.Button;
import me.emmy.cosmetics.api.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
public class CosmeticSelectMenu extends Menu {
    @Override
    public String getTitle(Player player) {
        return "Select a cosmetic";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        AtomicInteger slot = new AtomicInteger(10);

        this.plugin.getCosmeticRepository().getCosmetics().forEach(cosmetic -> {
            buttons.put(slot.getAndIncrement(), new CosmeticButton(cosmetic));
        });

//        this.plugin.getCosmeticRepository().getCosmetics().forEach(
//                cosmetic -> buttons.put(buttons.size(), new CosmeticButton(cosmetic)
//        ));

        this.addBorder(buttons, (byte) 15, 5);

        return buttons;
    }

    @Override
    public int getSize() {
        return 5 * 9;
    }
}