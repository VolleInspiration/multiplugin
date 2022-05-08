package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class unban
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public unban(Command cmd, String[] args, Player p, multiplugin plugin)
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
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "You invited too many players!");
			return false;
		}
		
		if (args.length == 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Invite a player!");
			return false;
		}
		
		if (args.length == 1) 
		{
			OfflinePlayer unban = plugin.getServer().getOfflinePlayer(args[0]);
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "Searching Player...");
		
			if(unban.isBanned())
			{
				unban.setBanned(false);
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + args[0] + " is unbanned now.");
			} else {
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You have not banned player: " + args[0]);
				return false;
			}
		}
		
	return false;
	}
}