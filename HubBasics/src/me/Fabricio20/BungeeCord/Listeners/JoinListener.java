package me.Fabricio20.BungeeCord.Listeners;

import me.Fabricio20.BungeeCord.API.UpdateAPI;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PostLoginEvent e) {
		if(UpdateAPI.isAvaliable) {
			if(e.getPlayer().hasPermission("HubBasics.UpdateAlert")) {
				e.getPlayer().sendMessage(new TextComponent("�9HubBasics > �eThere's an update aliable!"));
			}
		}
	}
	
}
