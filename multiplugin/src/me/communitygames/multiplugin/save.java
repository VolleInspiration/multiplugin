package me.communitygames.multiplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class save
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public save(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		if (args.length != 0)
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /save");
			return false;
		}
		
		if (args.length == 0) 
		{
			Command.broadcastCommandMessage(p, "Forcing save...");
			Bukkit.savePlayers();
			for (World world : Bukkit.getWorlds()) 
			{
				world.save();
				//TODO: autosave, einstellen in der config
			}
			Command.broadcastCommandMessage(p, "Save complete.");
			return true;
		}
	return false;
	}
}