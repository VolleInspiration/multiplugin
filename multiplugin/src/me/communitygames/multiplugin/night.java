package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class night
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public night(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		if(args.length == 0)
		{
			p.getLocation().getWorld().setTime(20000);
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You set time to night.");
			Command.broadcastCommandMessage(p,ChatColor.BLUE + p.getName() + " changed time to NIGHT.");
			return true;
		}
		
		if(args.length != 0)
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /night");
			return false;
		}
		
	return false;	
	}
}