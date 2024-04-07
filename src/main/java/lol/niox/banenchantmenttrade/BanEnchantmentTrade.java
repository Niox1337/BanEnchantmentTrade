package lol.niox.banenchantmenttrade;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class BanEnchantmentTrade extends JavaPlugin implements org.bukkit.event.Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("BanEnchantmentTrade has been enabled!");
    }


    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Merchant) {
            Merchant merchant = (Merchant) event.getRightClicked();
            List<MerchantRecipe> recipes = merchant.getRecipes();
            for (MerchantRecipe recipe : recipes) {
                System.out.println(recipe.getResult().getType());
                if (recipe.getResult().getType().toString().contains("ENCHANTED_BOOK")) {
                    recipe.setMaxUses(0);
                }
            }
        }
    }

}
