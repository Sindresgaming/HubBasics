package me.Fabricio20.Bukkit.API;

import me.Fabricio20.Bukkit.Main;
import me.Fabricio20.Bukkit.Storage.Permissions;
import me.Fabricio20.Bukkit.Methods.ModuleManager;
import me.Fabricio20.Bukkit.Methods.Managers.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MagicClockAPI {
	
	public static MagicClockAPI theClass = new MagicClockAPI();
	
	/**
	 * 
	 * @param player
	 * @return true if players are enabled
	 */
	@SuppressWarnings("deprecation")
	public boolean toggleClock(Player player) {
		if(ModuleManager.theClass.isInWorld(player)) {
			if(!SettingsManager.theClass.isPlayersEnabled(player.getName())) {
				for(Player ps: Bukkit.getOnlinePlayers()) {
					if(player.canSee(ps)) {
						if(Main.theClass.config.getBoolean("MagicClock.IgnoreBypass")) {
							player.hidePlayer(ps);
						} else {
							if(!ps.hasPermission(new Permissions().IgnoreMagicClock)) {
								player.hidePlayer(ps);
							}
						}
					}
				}
				return false;
			} else {
				for(Player ps: Bukkit.getOnlinePlayers()) {
					if(!player.canSee(ps)) {
						player.showPlayer(ps);
					}
				}
				return true;
			}
		} else {
			for(Player ps: Bukkit.getOnlinePlayers()) {
				if(!player.canSee(ps)) {
					player.showPlayer(ps);
				}
			}
			return true;
		}
	}
	
}
