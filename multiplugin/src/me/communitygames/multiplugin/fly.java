package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class fly
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public fly(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean execute()
	{
		if (args.length > 1) 
		{
			p.sendMessage(ChatColor.RED + "Wrong input! Use: /fly [target]");
			return false;
		}

		if (args.length == 0)
		{
			p.getAllowFlight();
			p.getFlySpeed();
			
			try 
			{
				if (p.getAllowFlight()) 
				{
					p.setAllowFlight(false);
					p.setFlying(false);
					p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You can't fly now!");
				}
				else
				{
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You can fly now!");

				} 
				{
					throw new NullPointerException();
				}
			} 
			catch (NullPointerException e) 
			{
				return false;
			}
		}

		if (args.length == 1) 
		{
			Player target = (Player) plugin.getServer().getPlayer(args[0]);
			
			try 
			{
				if (target.isOnline()) 
				{
					target.getAllowFlight();
					target.getFlySpeed();
					
					try 
					{
						if (target.getAllowFlight()) 
						{
							target.setAllowFlight(false);
							target.setFlying(false);
							target.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You can't fly, now.");
							p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + args[0] + ChatColor.GREEN + " can't fly, now.");
						} else {
							target.setAllowFlight(true);
							target.setFlying(true);
							target.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You can fly, now.");
							p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + args[0] + ChatColor.GREEN + " can fly, now.");
						}
						{
							throw new NullPointerException();
						}

					}
					catch (NullPointerException e)
					{
						return false;
					}
				}
				{
					throw new NullPointerException();
				}
			}
			catch (NullPointerException e) 
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + args[0] + ChatColor.GREEN + " is offline.");
				return false;
			}
		}
	return false;
	}
}