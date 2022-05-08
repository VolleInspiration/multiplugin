package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class isban
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public isban(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean execute()
	{
		if (args.length != 1) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /ban? <target>");
			return false;
		}
		
		if (args.length == 1) 
		{
			OfflinePlayer target = plugin.getServer().getOfflinePlayer(args[0]);
			
			if (target.isBanned())
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + args[0] + ChatColor.GREEN + " is banned.");
				return true;
			}
			else
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + args[0] + ChatColor.GREEN + " is NOT banned.");
			}
			return false;
		}
	return false;
	}
}