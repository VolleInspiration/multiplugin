package me.communitygames.multiplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class ban
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public ban(Command cmd, String[] args, Player p, multiplugin plugin)
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
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "You selected to many players!");
			return false;
		}
		
		if (args.length == 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Choose a player!");
			return false;
		}
		
		if (args.length == 1) 
		{
			String Playername = args[0];
			OfflinePlayer player = Bukkit.getOfflinePlayer(Playername);
			
			if (player == null)
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] "+ ChatColor.RED + "This player \"" + Playername + "\" could not be found!");
			}
			if(!player.isBanned())
			{
				player.setBanned(true);
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.BLUE + "You banned OfflinePlayer " + Playername);
				
				if (player.isOnline())
				{
					p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.BLUE + "You banned " + Playername);
					Command.broadcastCommandMessage(p,ChatColor.BLUE + p.getName() + " banned " + Playername + " !");
					((Player)player).kickPlayer("Du wurdest gebannt!");
				}		
				System.out.println("[multiplugin] " + p.getName() + " banned " + Playername);
			}
			else
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + args[0] + ChatColor.GREEN + " is banned.");
		}	
		return false;
	}
}