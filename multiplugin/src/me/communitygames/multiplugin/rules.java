package me.communitygames.multiplugin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class rules
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public rules(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	@SuppressWarnings("resource")
	public boolean execute()
	{
		if(args.length != 0)
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /rules");
			return false;
		}
		
		if(args.length == 0)
		{
			try 
			{
				BufferedReader in = new BufferedReader(new FileReader("plugins/multiplugin/rules.txt"));
				String zeile = null;
				
				p.sendMessage(ChatColor.GREEN + "RULES: " + "\n");
				
				while ((zeile = in.readLine()) != null)
				{
					p.sendMessage(zeile);		
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
	return false;
	}
}