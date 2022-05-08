package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class fill
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public fill(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		if (args.length > 0) 
		{
			p.sendMessage(ChatColor.RED + "Wrong input! Use: /fill");
			return false;
		}
		
		if (args.length == 0) 
		{
			Material block = p.getInventory().getItemInHand().getType();
			int amount =  p.getInventory().getItemInHand().getAmount();
			if(amount == 0)
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Select a item, please!");
				return false;
			}
			p.getInventory().addItem(new ItemStack(block, 64 - amount));
			return true;
		}
	return false;	
	}
}