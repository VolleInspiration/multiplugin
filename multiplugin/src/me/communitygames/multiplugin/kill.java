package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class kill
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public kill(Command cmd, String[] args, Player p, multiplugin plugin)
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
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.YELLOW + "Elimination failed!");
			return false;
		}

		if (args.length == 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Nice..., you have killed yourself :P");
			p.setHealth((int) 0.0);
			return true;
		}
		
		if (args.length == 1) 
		{
			try 
			{
				p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "Lokalize player...");
				Player ziel = (Player) plugin.getServer().getPlayer(args[0]);
				
				if (ziel.isOnline())
				{
					p.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.GREEN + " ... Elimination successfull. ^-^");
					@SuppressWarnings("unused")
					double health = (double) ((CraftPlayer)ziel).getHealth();
					ziel.setHealth((int) 0.0);
				} else {
					throw new NullPointerException();
				}
			} catch (NullPointerException e) {
				p.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.RED + " is offline. Discontinuation.");
				return false;
			}
		} else {
			return false;
		}
		
	return false;
	}
}