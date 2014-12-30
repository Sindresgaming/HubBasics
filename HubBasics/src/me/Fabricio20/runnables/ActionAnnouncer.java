package me.Fabricio20.runnables;

import java.util.ArrayList;
import java.util.List;

import me.Fabricio20.API.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionAnnouncer extends BukkitRunnable {
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private final JavaPlugin plugin;

	public ActionAnnouncer(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	List<String> Announces = new ArrayList<String>();
	List<String> Worlds = new ArrayList<String>();
	public static int Stamp = 0;
	int Max = 0;

	@SuppressWarnings("deprecation")
	public void run() {
		if (plugin.getConfig().getBoolean("ActionAnnouncer.Enabled") == true) {
			if (plugin.getConfig().getBoolean("ActionAnnouncer.Perworld") == false) {
				Announces = plugin.getConfig().getStringList("ActionAnnouncer.Msgs");
				int Max = Announces.size() - 1;
				if (Stamp == 0) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						ActionAPI.sendAction(player, Announces.get(0).replace("&", "�"));
					}
					Stamp = Stamp + 1;
				} else if (Stamp != 0 && Stamp != Max) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						ActionAPI.sendAction(player, Announces.get(Stamp).replace("&", "�"));
					}
					Stamp = Stamp + 1;
				} else if (Stamp == Max) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						ActionAPI.sendAction(player, Announces.get(Max).replace("&", "�"));
					}
					Stamp = 0;
				}
			} else {
				Announces = plugin.getConfig().getStringList("ActionAnnouncer.Msgs");
				Worlds = plugin.getConfig().getStringList("ActionAnnouncer.Worlds");
				int Max = Announces.size() - 1;
				if (Stamp == 0) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						if (Worlds.contains(player.getWorld().getName())) {
							ActionAPI.sendAction(player, Announces.get(0).replace("&", "�"));
						}
					}
					Stamp = Stamp + 1;
				} else if (Stamp != 0 && Stamp != Max) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						if (Worlds.contains(player.getWorld().getName())) {
							ActionAPI.sendAction(player, Announces.get(Stamp).replace("&", "�"));
						}
					}
					Stamp = Stamp + 1;
				} else if (Stamp == Max) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						if (Worlds.contains(player.getWorld().getName())) {
							ActionAPI.sendAction(player, Announces.get(Max).replace("&", "�"));
						}
					}
					Stamp = 0;
				}
			}
		}
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
