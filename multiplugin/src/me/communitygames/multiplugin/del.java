package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class del
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public del(Command cmd, String[] args, Player p, multiplugin plugin)
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
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use:");
			p.sendMessage(ChatColor.RED + "/del [target]");
			return false;
		}

		if (args.length == 0)
		{
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setBoots(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "Your inventory has been cleared.");
			return false;
		}

		if (args.length == 1) 
		{
			try 
			{
				Player target = (Player) plugin.getServer().getPlayer(args[0]);
			
				if (target.isOnline())
				{
					target.getInventory().clear();
					target.sendMessage("Your inventory has been cleared.");
					p.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.GREEN + "'s inventory has been cleared. Player is Online.");
				}
				else 
				{
					throw new NullPointerException();
				}
			}
			catch (NullPointerException e)
			{
				p.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.GREEN + " is offline. Try again later...");
				return false;
			}
		} 
		else
		{
			return false;
		}
	return false;	
	}
}