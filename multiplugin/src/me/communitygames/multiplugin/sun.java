package me.communitygames.multiplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class sun
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public sun(Command cmd, String[] args, Player p, multiplugin plugin)
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
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "Wrong input. Use: /sun");
			return false;
		}
		
		if (args.length == 0) 
		{
			World world = Bukkit.getWorlds().get(0);
			world.setStorm(false);
			world.setThundering(false);
			Command.broadcastCommandMessage(p,ChatColor.BLUE + p.getName() + " changed weather to clear.");
			return true;
		}
		
	return false;
	}
}