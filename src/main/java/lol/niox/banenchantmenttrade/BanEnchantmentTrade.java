package lol.niox.banenchantmenttrade;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;

public final class BanEnchantmentTrade extends JavaPlugin implements org.bukkit.event.Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("BanEnchantmentTrade has been enabled!");
    }


    @EventHandler
    public void onVillagerAcquireTrade(VillagerAcquireTradeEvent event) {
        System.out.println(event.getRecipe().getResult().getType());
        if (event.getRecipe().getResult().getType().toString().contains("ENCHANTED")) {
            event.setCancelled(true);
        }
    }

}
