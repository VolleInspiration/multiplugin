package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class isfly
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;
	Player target;

	public isfly(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean execute()
	{
		if (args.length >= 2) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /isfly <target>");
			return false;
		}
		
		if (args.length == 0)
		{
			if(p.getAllowFlight() == true){
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + p.getName() + ChatColor.GREEN + " has permissions to fly.");
				return true;
			} else {
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + p.getName() + ChatColor.GREEN + " don't have permissions to fly.");
				return true;
			}
		}
		
		if (args.length == 1) 
		{
			try 
			{
				if (target.isOnline())
				{
					try
					{
						if(target.getAllowFlight() == true){
							Player target = (Player) plugin.getServer().getPlayer(args[0]);
							p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + target.getName() + ChatColor.GREEN + " has permissions to fly.");
							return true;
						} else {
							p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + target.getName() + ChatColor.GREEN + " don't has permissions to fly.");
							return true;
						}
					}
					catch (NullPointerException e) 
					{
						p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "error - commandline for more details...");
						System.out.println("[multiplugin]\n" + e);
						return false;
					}
				}
				throw new NullPointerException();
			}
			catch (NullPointerException e)
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + args[0] + ChatColor.GREEN + " is OFFLINE!");
				return false;
			}
		}
	return false;
	}
}