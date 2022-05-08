package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
//import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPlayer;
//import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class pheal
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public pheal(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		if (args.length != 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin]" + ChatColor.RED + " You invited to many players!");
			return false;
		}
		else if (args.length == 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin]" + ChatColor.GREEN + " get well!");
			double health = p.getHealth();
			double pheal = plugin.getConfig().getInt("Config.heal-pheal");
			String msg = plugin.getConfig().getString("Config.message.heal-pheal-error");
			p.sendMessage(ChatColor.YELLOW + "[multiplugin]" + ChatColor.GREEN + " your health: " + health / 2);
			
			try
			{
				p.getPlayer().setHealth(p.getHealth() + (double)pheal);
				return true;
			} catch (Exception e){
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
		}
		return false;
	}
}