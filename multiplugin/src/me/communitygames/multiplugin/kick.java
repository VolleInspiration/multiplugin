package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class kick
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public kick(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean execute()
	{
		if (args.length == 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /kick [target]");
			return false;
		}
		
		if (args.length > 1) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /kick [target]");
			return false;
		}
		
		if (args.length == 1) 
		{
			try 
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "Lokalize player...");
				Player target = (Player) plugin.getServer().getPlayer(args[0]);
				
				if (target.isOnline()) 
				{
					p.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.GREEN + " is online and has kicked.");
					Command.broadcastCommandMessage(p, ChatColor.YELLOW + args[0] + ChatColor.RED + " has been kicked by an operator.");
					target.kickPlayer(args[0]);
				}
				else 
				{
					throw new NullPointerException();
				}
			}
			catch (NullPointerException e) 
			{
				p.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.RED + " is offline. Discontinuation.");
				return false;
			}
		}
	return false;
	}
}