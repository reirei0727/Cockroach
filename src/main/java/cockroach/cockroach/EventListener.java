package cockroach.cockroach;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventListener implements Listener {

    @EventHandler
    public void onMoveAdv(PlayerGameModeChangeEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.CREATIVE){
            p.setDisplayName(ChatColor.RED + p.getName() +ChatColor.RESET);
            p.setPlayerListName(ChatColor.RED + p.getName() +ChatColor.RESET);

            for (ItemStack stack : e.getPlayer().getInventory().getArmorContents()) {
                if (stack.getType() == Material.DIAMOND_BOOTS) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,100000,5,false,false));
                } else if(stack.getType() == Material.LEATHER_BOOTS){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,100000,3,false,false));
                }
            }

        }
        if(p.getGameMode() == GameMode.ADVENTURE){
            p.setDisplayName(ChatColor.WHITE + p.getName() +ChatColor.RESET);
            p.setPlayerListName(ChatColor.WHITE + p.getName() +ChatColor.RESET);
            p.sendMessage("アドベンチャーじゃなくなった");
            for(PotionEffect effect:p.getActivePotionEffects()){
                p.removePotionEffect(effect.getType());
            }
        }
    }
}
