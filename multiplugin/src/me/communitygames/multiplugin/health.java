package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
//import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class health
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public health(Command cmd, String[] args, Player p, multiplugin plugin)
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
			p.sendMessage(ChatColor.YELLOW + "[multiplugin]" + ChatColor.RED + " You invited too many players!");
			return false;
		}

		if (args.length == 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin]" + ChatColor.GREEN + " get well!");
			double health = p.getHealth();
			p.sendMessage(ChatColor.YELLOW + "[multiplugin]" + ChatColor.GREEN + " your health: " + health / 2 + " and is now: level 10.0");
			p.setHealth((int) 20.0);
			return true;
		}

		if (args.length == 1) 
		{
			try 
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + " Lokalize player...");
				Player target = (Player) plugin.getServer().getPlayer(args[0]);
				
				if (target.isOnline()) 
				{
					p.sendMessage(ChatColor.YELLOW + target.getName() + ChatColor.GREEN + " is online and has been healed.");
					@SuppressWarnings("unused")
					double health = target.getHealth();
					target.setHealth((int) 20.0);
					target.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You have been healed by " + p.getName());
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