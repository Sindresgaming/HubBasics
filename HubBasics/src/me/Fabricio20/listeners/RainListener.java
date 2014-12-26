package me.Fabricio20.listeners;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RainListener implements Listener {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private final JavaPlugin plugin;

	public RainListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@EventHandler(priority = EventPriority.HIGH)
	public void RainStart(WeatherChangeEvent e) {
		if(plugin.getConfig().getBoolean("Others.DisableRain") == true) {
			List<String> worlds = plugin.getConfig().getStringList("Worlds");
			if(worlds.contains(e.getWorld().getName())) {
				if(!e.isCancelled()) {
					e.setCancelled(true);
				}
			}
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
