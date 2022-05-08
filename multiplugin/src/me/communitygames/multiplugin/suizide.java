package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class suizide
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public suizide(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		if(args.length != 0)
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use /suizide");
			return false;
		}
		
		if(args.length == 0)
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + " ... Elimination successfull. ^-^");
			p.setHealth((int) 0.0);
			return true;
		}
		return false;
	}
}