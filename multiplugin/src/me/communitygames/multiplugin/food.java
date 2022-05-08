package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class food
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public food(Command cmd, String[] args, Player p, multiplugin plugin)
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
			p.sendMessage(ChatColor.RED + "Wrong input! Use /food");
			return false;
		}

		if (args.length == 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin]" + ChatColor.GREEN + " Your FoodLevel is full!");
			float food = p.getFoodLevel();
			p.sendMessage(ChatColor.YELLOW + "[multiplugin]" + ChatColor.GREEN + " Your FoodLevel was: " + food / 2 + " and is now: 10.0");
			p.setFoodLevel(20);
			return true;
		}
		
		if (args.length == 1) 
		{
			try 
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "Lokalize player...");
				Player target = (Player) plugin.getServer().getPlayer(args[0]);
				//TODO getServer und getPlayer
				if (target.isOnline()) 
				{
					p.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.GREEN + " is online and get well.");
					target.getFoodLevel();
					target.setFoodLevel(20);
					target.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "Your FoodLevel is full.");
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