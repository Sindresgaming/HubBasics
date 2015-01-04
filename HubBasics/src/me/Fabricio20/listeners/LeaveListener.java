package me.Fabricio20.listeners;

import me.Fabricio20.Main;
import me.Fabricio20.Strings;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGH)
	public void Leave(PlayerQuitEvent e) {
		if(Main.getPlugin().getConfig().getBoolean("LeaveEvents.DisableLeaveMessage") == true) {
			e.setQuitMessage(null);
		} else {
			e.setQuitMessage(Main.getPlugin().getConfig().getString("LeaveEvents.Message").replace("&", "�").replace("%p", e.getPlayer().getName()));
		}
		if(Main.getPlugin().getConfig().getBoolean("LeaveEvents.SilentOpLeave") == true) {
			if(e.getPlayer().isOp()) {
				e.setQuitMessage(null);
			}
		}
		for(Player user : Bukkit.getOnlinePlayers()) {
			if(Strings.MagicClockActive.contains(user)) {
				if(user.canSee(e.getPlayer()) == false) {
					user.showPlayer(e.getPlayer());
				}
			}
		}
		if(Strings.MagicClockActive.contains(e.getPlayer())) {
			for(Player users : Bukkit.getOnlinePlayers()) {
				if(e.getPlayer().canSee(users) == false) {
					e.getPlayer().showPlayer(users);
				}
			}
			Strings.MagicClockActive.remove(e.getPlayer());
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
