package me.Fabricio20.Bukkit.Listeners.Item;

import me.Fabricio20.Bukkit.Main;
import me.Fabricio20.Bukkit.API.ItemsAPI;
import me.Fabricio20.Bukkit.Methods.ModuleManager;
import me.Fabricio20.Bukkit.Methods.Managers.SettingsManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemListener implements Listener {
	
	@EventHandler
	public void Drop(PlayerDropItemEvent e) {
		if(Main.theClass.config.getBoolean("Others.NoDrops") == true) {
			if(ModuleManager.theClass.isInWorld(e.getPlayer())) {
				e.setCancelled(true);
			}
		}
		if(Main.theClass.config.getBoolean("MagicClock.NoDrop") == true) {
			if(ModuleManager.theClass.isInWorld(e.getPlayer())) {
				if(e.getItemDrop().getItemStack().equals(ItemsAPI.get("MagicClock", SettingsManager.theClass.isPlayersEnabled(e.getPlayer().getName())))) {
					e.setCancelled(true);
				}
			}
		}
		if(Main.theClass.config.getBoolean("HatSystem.AllowDrops") == false) {
			if(ModuleManager.theClass.isInWorld(e.getPlayer())) {
				if(e.getItemDrop().getItemStack().hasItemMeta()) {
					if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains(Main.theClass.config.getString("HatSystem.Name").substring(3))) {
						e.setCancelled(true);
					}
				}
			}
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
