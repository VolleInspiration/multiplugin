package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class day
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public day(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		if(args.length == 0)
		{
			p.getLocation().getWorld().setTime(0000);
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You set time to day.");
			Command.broadcastCommandMessage(p,ChatColor.BLUE + p.getName() + " changed time to DAY.");
			return true;
		}
	
		if(args.length != 0)
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /day");
			return false;
		}
	return false;
	}
}