package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class hello
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public hello(Command cmd, String[] args, Player p, multiplugin plugin)
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
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /hello");
			return false;
		}
		
		if(args.length == 0)
		{
			String msg = plugin.getConfig().getString("Config.message.hello");
			msg = msg.replace("%p%", p.getName());
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			return true;
		}
		else 
		{
			return false;
		}
	}
}