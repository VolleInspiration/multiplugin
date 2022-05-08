package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class broadcast
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public broadcast(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		if (args.length == 0) 
		{
			// Laden der Nachricht aus der Config
			String rundruf = plugin.getConfig().getString("Config.message.broadcast");

			p.sendMessage(ChatColor.GREEN + "Broadcast send!");
			plugin.getServer().broadcastMessage(ChatColor.BLUE + "Attention: " + ChatColor.RED + rundruf);
			return true;
		}
		else 
		{
			p.sendMessage(ChatColor.RED + "Wrong input! Use: /broadcast");
			return false;
		}
	}
}