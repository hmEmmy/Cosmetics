package me.emmy.cosmetics.cosmetic.command;

import me.emmy.cosmetics.cosmetic.menu.CosmeticSelectMenu;
import me.emmy.cosmetics.util.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
public class CosmeticsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.translate("&cThis command can only be executed by a player!"));
            return true;
        }

        Player player = (Player) sender;
        new CosmeticSelectMenu().openMenu(player);
        return true;
    }
}