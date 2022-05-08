package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class gma
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public gma(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean execute()
	{
		if(args.length == 0)
		{
			p.setGameMode(GameMode.ADVENTURE);
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.BLUE + "Your Gamemode: " + ChatColor.YELLOW + "ADVENTURE");
			return true;
		}
		
		if(args.length > 1)
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input. Use /gma [target]");
			return false;
		}
		
		if(args.length == 1)
		{
			Player gmp = (Player) plugin.getServer().getPlayer(args[0]);
			//TODO getServer and getPlayer
			try
			{
				if(gmp.isOnline())
				{
					gmp.setGameMode(GameMode.ADVENTURE);
					gmp.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.DARK_PURPLE + "Gamemode was changed: ADVENTURE");
					p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.DARK_PURPLE + "Gamemode was changed: ADVENTURE from " + ChatColor.GREEN + args[0]);
					return true;
				} 
				else
				{
					return false;
				}
			
			}
			catch (NullPointerException e)
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.BLUE + args[0] + ChatColor.RED + " is OFFLINE!");
				return false;
			}
		}
		return false;
	}
}