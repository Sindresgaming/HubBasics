package me.Fabricio20.listeners;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class MoveListener implements Listener {
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private final JavaPlugin plugin;

	public MoveListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private ArrayList<Player> jumpers = new ArrayList<Player>();
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
            if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.getMaterial(plugin.getConfig().getString("JumpPadBlock"))) {
			if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL) || e.getPlayer().getGameMode().equals(GameMode.ADVENTURE)) {
				e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(3));
				e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
				jumpers.add(e.getPlayer());
			}
		}
    }
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
            if (e.getEntity() instanceof Player) {
                    Player p = (Player) e.getEntity();
                    if (e.getCause() == DamageCause.FALL && jumpers.contains(p)) {
                            e.setDamage(0.0);
                            jumpers.remove(p);
                    }
            }
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
}
