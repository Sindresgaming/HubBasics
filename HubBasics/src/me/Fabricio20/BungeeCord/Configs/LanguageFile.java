package me.Fabricio20.BungeeCord.Configs;

import java.io.File;
import java.util.ArrayList;

import me.Fabricio20.BungeeCord.FixConfig;
import me.Fabricio20.BungeeCord.Main;
import net.cubespace.Yamler.Config.Comment;
import net.cubespace.Yamler.Config.Config;
import net.md_5.bungee.api.plugin.Plugin;

public class LanguageFile extends Config {
	
	public LanguageFile(Plugin plugin) {
		CONFIG_HEADER = new String[]{"HubBasics Language File", "Change With Caution"};
	    CONFIG_FILE = new File(plugin.getDataFolder(), "Language.yml");
	}
	
	@Comment("Friends Command Usage Message")
	public ArrayList<String> Friends_Usage = FixConfig.Friends_Usage();
	
	@Comment("Here you can change the friends list message")
	public String Friends_List = "&aFriends: &9";
	
	@Comment("Here you can change the separator color for list and online commands!")
	public String Friends_SeparatorColor = "&e";
	
	@Comment("Here you can change the friend added message")
	public ArrayList<String> Friends_Added = FixConfig.Friends_Added();
	
	@Comment("Here you can change the friend added message")
	public ArrayList<String> Friends_Removed = FixConfig.Friends_Removed();
	
	@Comment("Here you can change the friend request sent message")
	public ArrayList<String> Friends_RequestSent = FixConfig.Friends_RequestSent();
	
	@Comment("Here you can change the 'this player is not your friend' message")
	public ArrayList<String> Friends_NotFriend = FixConfig.Friends_NotFriend();
	
	@Comment("Here you can change the friend request received message")
	public ArrayList<String> Friends_RequestReceived = Main.theClass.WantsToBe;
	
	@Comment("Here you can edit the already sent request message")
	public ArrayList<String> Friends_AlreadyAsked = FixConfig.Friends_AlreadyAsked();
	
	@Comment("Here you can edit the request not found message")
	public ArrayList<String> Friends_RequestNotThere = FixConfig.Friends_RequestNotThere();
	
	@Comment("Here you can change the request removed message")
	public ArrayList<String> Friends_RequestRemoved = FixConfig.Friends_RequestRemoved();
	
	@Comment("Here you can change the friend not found message")
	public ArrayList<String> Friends_NotFound = FixConfig.Friends_NotFound();
	
	@Comment("Here you can change the online hover message")
	public ArrayList<String> Friends_HoverOnline = FixConfig.Friends_HoverOnline();
	
	@Comment("Here you can change the offline hover message")
	public ArrayList<String> Friends_HoverOffline = FixConfig.Friends_HoverOffline();
	
	@Comment("Here you can change the you cant add yourself message")
	public ArrayList<String> Friends_CantAddYourSelf = FixConfig.Friends_CantAddYourSelf();
	
	@Comment("Here you can change the cannot follow message")
	public ArrayList<String> Friends_CannotFollow = FixConfig.Friends_CannotFollow();
	
	@Comment("Here you can change the friend joined message")
	public ArrayList<String> Friends_Joined = FixConfig.Friends_Joined();
	
	/** --------------------------------------- END FRIENDS SYSTEM ----------------------------------------------- **/
	
	@Comment("Here you can change the Alert usage message")
	public ArrayList<String> Alert_Usage = FixConfig.Alert_Usage();
	
	@Comment("Here you can change the appearence of the Alert system")
	public String Alert_Format = "&7[&cALERT&7]: &c{message}";
	
	/** ----------------------------------------END ALERT SYSTEM ------------------------------------------ **/
	
	@Comment("Here you can change the lobby system teleport message")
	public ArrayList<String> Lobby_Teleporting = FixConfig.Lobby_Teleporting();
	
	/** ----------------------------------------END LOBBY SYSTEM ------------------------------------------ **/
	
	@Comment("Here you can change the unkown server message")
	public ArrayList<String> General_UnkownServer = FixConfig.General_UnkownServer();
	
	@Comment("Here you can change the only players message")
	public ArrayList<String> General_OnlyPlayers = FixConfig.General_OnlyPlayers();
	
}
