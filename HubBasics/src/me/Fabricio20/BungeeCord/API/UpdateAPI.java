package me.Fabricio20.BungeeCord.API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import me.Fabricio20.Global.GlobalStrings;
import net.md_5.bungee.BungeeCord;

public class UpdateAPI {
	
public static boolean isAvaliable = false;
	
	public static void checkUpdate() {
		List<String> info = new ArrayList<String>();
		URL host = null;
		URLConnection connection = null;
		BufferedReader reader = null;
		try {
			host = new URL("http://fallcraft.com.br/exploitbr/hubbasics.txt");
			connection = host.openConnection();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				info.add(inputLine);
			}
			if(!info.contains(GlobalStrings.Version)) {
				isAvaliable = true;
				BungeeCord.getInstance().getLogger().log(Level.INFO, "[HubBasics] There's An Update Avaliable!");
			} else {
				BungeeCord.getInstance().getLogger().log(Level.INFO, "[HubBasics] No Update Found!");
			}
		} catch (Exception ex) {
			BungeeCord.getInstance().getLogger().log(Level.INFO, "[HubBasics] Could Not Verify Update!");
			return;
		}
	}
	
	public static void silentCheck() {
		List<String> info = new ArrayList<String>();
		URL host = null;
		URLConnection connection = null;
		BufferedReader reader = null;
		try {
			host = new URL("http://fallcraft.com.br/exploitbr/hubbasics.txt");
			connection = host.openConnection();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				info.add(inputLine);
			}
			if(!info.contains(GlobalStrings.Version)) {
				isAvaliable = true;
				BungeeCord.getInstance().getLogger().log(Level.INFO, "[HubBasics] There's An Update Avaliable!");
			}
		} catch (Exception ex) {
			return;
		}
	}
	
}
