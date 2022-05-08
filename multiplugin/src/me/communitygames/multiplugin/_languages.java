package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class _languages
{
	
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public _languages(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	@SuppressWarnings("unused")
	public boolean execute()
	{
		/*
		 * *
		 * 
		 * TODO: Sprachauswahl, Texte aus Datei auslesen, Datei erstellen
		 * neue Idee: im Plugin, wenn STRG gedrückt, dann heranzoomen
		 * *
		 */
			String language = plugin.getConfig().getString("Config.test.language");
			if(language.equalsIgnoreCase("De"))
			{
				String getArmorEN = ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "TTTTTTEEEEEEEESSSSSSSSTTTTTTTTT!";
				p.sendMessage("ffff");
				
			} // else DE
			else
			{
				p.sendMessage("nee");
			}
		return false;
	}
	
}